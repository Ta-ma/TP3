package item;

import unidad.Unidad;

/**
 * Este item duplica la energía, pero reduce el daño en 10%
 */
public class Capa extends Item 
{
	private static final int ID_ITEM_CAPA = 4;
	
	public Capa(Unidad unidad) throws Exception 
	{
		super(unidad);
		
		// verifico que no tenga equipado el mismo item
		if ((unidad.getItemsEquipados() & ID_ITEM_CAPA) != 0)
			throw new Exception("Ya tiene una capa equipada!");
		
		// duplica la energía al equiparse
		unidad.setEnergia(unidad.getEnergia() * 2);
	}
	
	@Override
	public int getItemsEquipados ()
	{
		return this.unidad.getItemsEquipados() + ID_ITEM_CAPA;
	}
	
	@Override
	public int getDaño ()
	{
		// trunca el daño si es que quedó con decimales
		return (int) (this.unidad.getDaño() * 0.9);
	}
	
	@Override
	public void descripcion(){
		System.out.println("Energia x 2 \n -10% Daño");
	}

}
