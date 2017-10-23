package item;

import unidad.Punto;
import unidad.Unidad;

/**
 * Clase padre de los items. 
 * Todos los métodos tienen complejidad computacional O(1).
 */
public abstract class Item extends Unidad
{
	protected Unidad unidad;

	/**
	 * Descripción del item.
	 */
	abstract void descripcion();
	
	/**
	 * Constructor que necesita la referencia de la unidad a la que se le equipará el item.
	 */
	public Item (Unidad unidad)
	{
		this.unidad = unidad;
	}
	
	public boolean puedoAtacar(Unidad objetivo)
	{
		return this.unidad.puedoAtacar(objetivo);
	}
	
	public boolean muerta ()
	{
		return this.unidad.muerta();
	}
	
	/**
	 * Retorna la salud de la unidad que tiene equipado este item.
	 */
	public int getSalud() 
	{
		return this.unidad.getSalud();
	}
	
	/**
	 * Cambia la salud de la unidad que tiene equipado este item.
	 * @param salud número de salud a asignarle a la unidad
	 */
	public void setSalud(int salud) 
	{
		this.unidad.setSalud(salud);
	}

	/**
	 * Retorna la defensa de la unidad que tiene equipado este item.
	 */
	public int getDefensa() 
	{
		return this.unidad.getDefensa();
	}

	/**
	 * Cambia la defensa de la unidad que tiene equipado este item.
	 * @param defensa número de defensa a asignarle a la unidad
	 */
	public void setDefensa(int defensa) 
	{
		this.unidad.setDefensa(defensa);;
	}

	/**
	 * Retorna la energía de la unidad que tiene equipado este item.
	 */
	public int getEnergia() 
	{
		return this.unidad.getEnergia();
	}

	/**
	 * Cambia la energía de la unidad que tiene equipado este item.
	 * @param energía número de energía a asignarle a la unidad
	 */
	public void setEnergia(int energia) 
	{
		this.unidad.setEnergia(energia);;
	}

	/**
	 * Retorna la posición de la unidad que tiene equipado este item.
	 */
	public Punto getPos() 
	{
		return this.unidad.getPos();
	}
	
	/**
	 * Cambia la posición de la unidad que tiene equipado este item.
	 * @param posición Punto de la posición a la que se moverá la unidad
	 */
	public void moverA(Punto pos) 
	{
		this.unidad.moverA(pos);;
	}

	/**
	 * Retorna el daño de la unidad que tiene equipado este item.
	 */
	public int getDaño() 
	{
		return this.unidad.getDaño();
	}
	
	@Override
	public void recargarFlechas () 
	{
		this.unidad.recargarFlechas();
	}
	
	@Override
	public int getFlechas () 
	{
		return this.unidad.getFlechas();
	}
	
	@Override
	public void setFlechas (int flechas) 
	{
		this.unidad.setFlechas(flechas);
	}
	
	@Override
	public void beberPoción() 
	{
		this.unidad.beberPoción();
	}
	
}
