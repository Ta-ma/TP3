package unidad;

/**
 * 
 * Esta unidad no puede realizar más de tres ataque seguidos. Necesita tomar una
 * poción de agua para volver a atacar.
 * 
 */
public class Caballero extends Unidad
{
	private static final int DISTANCIA_CABALLERO_MIN = 1;
	private static final int DISTANCIA_CABALLERO_MAX = 2;
	private static final int SALUD = 200;
	private static final int DAÑO = 50;
	int contadorAtaques; /// SOLO PUEDE ATACAR 3 VECES SEGUIDAS, DEBE TOMAR
							/// POCION PARA ATACAR NUEVAMENTE

	public Caballero()
	{
		super(SALUD, DAÑO, DISTANCIA_CABALLERO_MIN, DISTANCIA_CABALLERO_MAX, new Punto());
	}

	public Caballero(Punto pos)
	{
		super(SALUD, DAÑO, DISTANCIA_CABALLERO_MIN, DISTANCIA_CABALLERO_MAX, pos);
	}

	@Override
	public boolean puedoAtacar(Unidad objetivo)
	{
		if (estaEnRango(objetivo) && contadorAtaques < 3)
		{
			contadorAtaques++;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @see unidad.Unidad#mostrarStats()
	 */
	@Override
	public void mostrarStats()
	{
		System.out.println("Caballero:");
		System.out.println("---------------");
		super.mostrarStats();
		System.out.println("Ataques realizados: " + this.contadorAtaques);
		System.out.println("---------------");
	}

	/**
	 * Reinicia el contador de ataques, por lo que el caballero puede volver a
	 * atacar.
	 * 
	 * @see unidad.BebenPoción#beberPoción()
	 */
	@Override
	public void beberPoción()
	{
		this.contadorAtaques = 0;
	}

}