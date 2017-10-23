package item;

import unidad.Unidad;

/**
 * La unidad que posea este item recibirá solamente el 40% del daño enemigo.
 */

public class Escudo extends Item
{
	private static final int ID_ITEM_ESCUDO = 2;

	public Escudo(Unidad unidad) throws Exception
	{
		super(unidad);

		// verifico que no tenga equipado el mismo item
		if ((unidad.getItemsEquipados() & ID_ITEM_ESCUDO) != 0)
			throw new Exception("Ya tiene un escudo equipado!");
	}

	@Override
	public void serDañado(int dañoRecibido)
	{
		int dañoFinal = dañoRecibido <= this.getDefensa() ? 0 : dañoRecibido - this.getDefensa();
		dañoFinal = (int) (dañoFinal * 0.4);

		this.setSalud(this.getSalud() - dañoFinal);
	}

	@Override
	public int getItemsEquipados()
	{
		return this.unidad.getItemsEquipados() + ID_ITEM_ESCUDO;
	}

	@Override
	public void descripcion()
	{
		System.out.println("+40% Defensa");
	}

}
