package unidad;

/**
 *
 * Limitación de ataque -ENERGIA. Realizar un ataque consume 10 puntos de
 * energia.
 */

public class Soldado extends Unidad
{
	private final static int DISTANCIA_SOLDADO_MIN = 0;
	private final static int DISTANCIA_SOLDADO_MAX = 1;
	private static final int SALUD = 200;
	private static final int DAÑO = 10;
	private static final int ENERGIAMAX = 100;

	public Soldado()
	{
		super(SALUD, DAÑO, DISTANCIA_SOLDADO_MIN, DISTANCIA_SOLDADO_MAX, new Punto());
		this.energia = ENERGIAMAX;
	}

	public Soldado(Punto pos)
	{
		super(SALUD, DAÑO, DISTANCIA_SOLDADO_MIN, DISTANCIA_SOLDADO_MAX, pos);
		this.energia = ENERGIAMAX;
	}

	@Override
	public void mostrarStats()
	{
		System.out.println("Soldado:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Energía: " + this.energia);
		System.out.println("---------------");
	}

	@Override
	public void beberPoción()
	{
		this.energia = ENERGIAMAX;
	}

	@Override
	public boolean puedoAtacar(Unidad objetivo)
	{
		if (estaEnRango(objetivo) && this.energia >= 10)
		{
			this.energia -= 10;
			return true;
		}
		return false;
	}

}