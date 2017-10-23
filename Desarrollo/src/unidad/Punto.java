package unidad;

/**
 * Pocicion x, y de las unidades
 */
public class Punto
{
	double x, y;
	
	public Punto ()
	{
	}
	
	public Punto (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Obtiene la distancia entre 2 posiciones.
	 */
	
	public double distancia (Punto punto)
	{
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}
}
