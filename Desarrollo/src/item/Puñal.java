package item;

import unidad.Unidad;

/**
 * Aumenta en 3 los puntos de ataque, pero reduce en 3 los puntos de defensa.
 */
public class Puñal extends Item 
{
	private static final int ID_ITEM_PUÑAL = 1;
	
	public Puñal(Unidad unidad) throws Exception 
	{
		super(unidad);
		
		// verifico que no tenga equipado el mismo item
		if ((unidad.getItemsEquipados() & ID_ITEM_PUÑAL) != 0)
			throw new Exception("Ya tiene un puñal equipado!");
	}
	
	@Override
	public int getDaño ()
	{
		return this.unidad.getDaño() + 3;
	}
	
	@Override
	public int getDefensa ()
	{
		return this.unidad.getDefensa() - 3;
	}
	
	@Override
	public int getItemsEquipados ()
	{
		return this.unidad.getItemsEquipados() + ID_ITEM_PUÑAL;
	}
	
	@Override
	public void descripcion() {
		System.out.println("+3 Daño \n -3 Defensa");
	}

}
