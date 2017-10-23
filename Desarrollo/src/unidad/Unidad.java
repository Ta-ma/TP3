package unidad;

import java.util.ArrayList;
import java.util.List;
import item.Item;

/**
 * CLASE PADRE DE LAS UNIDADES 
 * Todos los métodos tienen complejidad computacional O(1).
 */
public abstract class Unidad
{
	int salud, daño, defensa, energia, itemsEquipados;
	int distanciaAtaqueMax, distanciaAtaqueMin;
	Punto pos;

	public abstract boolean puedoAtacar(Unidad objetivo);

	/**
	 * Constructor vacío para poder usar Decorator con los items.
	 */
	protected Unidad()
	{
	}

	/**
	 * Constructos de unidades Todas las unidades comienzan con defensa 0
	 * 
	 * @param salud
	 *            Salud de la unidad
	 * @param daño
	 *            Daño que puede efectuar
	 * @param distanciaAtaqueMin
	 *            distancia de ataque efectivo minimo
	 * @param distanciaAtaqueMax
	 *            distancia de ataque efectivo maximo
	 * @param pos
	 *            posición del la unidad [x,y]
	 */
	public Unidad(int salud, int daño, int distanciaAtaqueMin, int distanciaAtaqueMax, Punto pos)
	{
		this.salud = salud;
		this.daño = daño;
		this.distanciaAtaqueMax = distanciaAtaqueMax;
		this.distanciaAtaqueMin = distanciaAtaqueMin;
		this.pos = pos;
		this.defensa = 0;
	}

	/*
	 * Método de testeo. Muestra los stats de la unidad.
	 */
	public void mostrarStats()
	{
		System.out.println("Daño: " + this.getDaño());
		System.out.println("Salud: " + this.getSalud());
		System.out.println("Defensa: " + this.getDefensa());
	}

	/**
	 * Informa si la unidad está muerta.
	 * 
	 * @return Retorna TRUE si la unidad está muerta
	 */
	public boolean muerta()
	{
		return this.salud == 0;
	}

	/**
	 * Se comprueba si está dentro del alcance permitido para atacar.
	 */
	protected boolean estaEnRango(Unidad objetivo)
	{
		double dist = this.pos.distancia(objetivo.pos);
		return dist >= distanciaAtaqueMin && dist <= distanciaAtaqueMax;
	}

	/**
	 * Se evalua primero si puede realizar una ataque, si el enemigo no está
	 * muerto y que el enemigo no sea él mismo. Si todo lo anterior se cumple
	 * procede a realizar un ataque.
	 * 
	 * @param objetivo
	 *            unidad que será afectada por los ataques
	 */
	public void atacarA(Unidad objetivo)
	{

		if (puedoAtacar(objetivo) && objetivo.muerta() == false && !objetivo.equals(this) && this.muerta() == false)
			this.dañar(objetivo);
		/*
		 * else System.out.println("Esta MUERTO");
		 */
	}

	/**
	 * Ejecuta el ataque, llamando al método serDañado del objetivo.
	 * 
	 * @param objetivo unidad a dañar
	 */
	public void dañar(Unidad objetivo)
	{
		objetivo.serDañado(this.getDaño());
	}

	/**
	 * Aplica la reducción de salud a la unidad en base al daño recibido.
	 * @param dañoRecibido cantidad de daño recibido
	 */
	public void serDañado(int dañoRecibido)
	{
		int dañoFinal = dañoRecibido <= this.getDefensa() ? 0 : dañoRecibido - this.getDefensa();
		this.setSalud(this.getSalud() - dañoFinal);
	}

	/**
	 * Comprueba la exixtencia de un Item en concreto.
	 * 
	 * @param idItem
	 *            número de id del item
	 * @return true si tiene el item equipado
	 */
	public boolean tieneItem(int idItem)
	{
		return (this.getItemsEquipados() & idItem) != 0;
	}

	/**
	 * Retorna la salud de la unidad.
	 */
	public int getSalud()
	{
		return salud;
	}

	/**
	 * Cambia la salud de la unidad. De ser negativa le asigna un 0.
	 * 
	 * @param salud
	 *            número de salud a asignarle a la unidad
	 */
	public void setSalud(int salud)
	{
		this.salud = salud < 0 ? 0 : salud;
	}

	/**
	 * Retorna la defensa de la unidad.
	 */
	public int getDefensa()
	{
		return defensa;
	}

	/**
	 * Cambia la defensa de la unidad.
	 * 
	 * @param defensa
	 *            número de defensa a asignarle a la unidad
	 */
	public void setDefensa(int defensa)
	{
		this.defensa = defensa;
	}

	/**
	 * Retorna la energía de la unidad.
	 */
	public int getEnergia()
	{
		return energia;
	}

	/**
	 * Cambia la energía de la unidad.
	 * 
	 * @param energía
	 *            número de energía a asignarle a la unidad
	 */
	public void setEnergia(int energia)
	{
		this.energia = energia;
	}

	/**
	 * Retorna la posición de la unidad.
	 */
	public Punto getPos()
	{
		return this.pos;
	}

	/**
	 * Mueve a la unidad a una determinada posición.
	 * 
	 * @param pos
	 *            posición a la cual se moverá la unidad.
	 */
	public void moverA(Punto pos)
	{
		this.pos = pos;
	}

	/**
	 * Retorna el daño de la unidad.
	 */
	public int getDaño()
	{
		return this.daño;
	}

	/**
	 * Retorna el número lógico que representa los items equipados.
	 */
	public int getItemsEquipados()
	{
		return this.itemsEquipados;
	}

	/**
	 * Métodos que serán sobreescritos por las subclases
	 */

	public void recargarFlechas(){}
	public int getFlechas(){return 0;}
	public void setFlechas(int flechas){}
	public void beberPoción(){}
}
