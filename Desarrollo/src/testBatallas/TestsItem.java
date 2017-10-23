package testBatallas;

import org.junit.Assert;
import org.junit.Test;

import item.Capa;
import item.Escudo;
import item.Puñal;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Punto;
import unidad.Soldado;
import unidad.Unidad;

public class TestsItem 
{
	@Test
	public void equiparPuñal() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		
		Assert.assertEquals(8, legolas.getDaño());
		Assert.assertEquals(-3, legolas.getDefensa());
	}
	
	@Test
	public void equiparCapa() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Capa(leonidas);
		
		Assert.assertEquals(200, leonidas.getEnergia());
	}
	
	@Test
	public void equiparEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));	//ataque de 50 ps

		Unidad soldier = new Soldado();
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);		//daño recibido 20 (40%)
		
		Assert.assertEquals(180, soldier.getSalud());
	}
	
	@Test
	public void equiparCapaEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Capa(soldier);
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);
		
		Assert.assertEquals(180, soldier.getSalud());
		Assert.assertEquals(200, soldier.getEnergia());
	}
	
	@Test
	public void equiparPuñalEscudo () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Puñal(soldier);
		soldier = new Escudo(soldier);
		knight.atacarA(soldier);
		
		Assert.assertEquals(179, soldier.getSalud());
	}
	
	@Test
	public void equiparPuñalCapa () throws Exception
	{
		Caballero knight = new Caballero(new Punto(0, 1));

		Unidad soldier = new Soldado();
		soldier = new Puñal(soldier);
		soldier = new Capa(soldier);
		soldier.atacarA(knight);
		
		Assert.assertEquals(11, soldier.getDaño());
		Assert.assertEquals(190, soldier.getEnergia());
		Assert.assertEquals(189, knight.getSalud());
	}
	
	@Test
	public void equiparPuñalCapaEscudo() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		legolas = new Capa(legolas);
		legolas = new Escudo(legolas);
		
		Assert.assertEquals(7, legolas.getDaño());
		Assert.assertEquals(-3, legolas.getDefensa());
		
		Caballero knight = new Caballero(new Punto(0, 1));
		knight.atacarA(legolas);
		Assert.assertEquals(29, legolas.getSalud());
	}
	
	@Test
	public void equiparCaballero() throws Exception
	{
		Unidad aragorn = new Caballero(new Punto(1, 1));
		
		aragorn = new Puñal(aragorn);
		aragorn = new Capa(aragorn);
		aragorn = new Escudo(aragorn);
		
		Unidad lancer = new Lancero(new Punto(0, 0));
		
		Assert.assertEquals(47, aragorn.getDaño());
		Assert.assertEquals(true, aragorn.puedoAtacar(lancer));
		aragorn.atacarA(lancer);
		aragorn.atacarA(lancer);
		aragorn.atacarA(lancer);
		Assert.assertEquals(false, aragorn.puedoAtacar(lancer));
		aragorn.beberPoción();
		Assert.assertEquals(true, aragorn.puedoAtacar(lancer));
	}
	
	@Test
	public void equiparSoldado() throws Exception
	{
		Unidad leonidas = new Soldado();
		leonidas = new Puñal(leonidas);
		leonidas = new Capa(leonidas);
		leonidas = new Escudo(leonidas);
		
		Unidad lancer = new Lancero(new Punto(0, 0));
		
		Assert.assertEquals(11, leonidas.getDaño());
		Assert.assertEquals(-3, leonidas.getDefensa());
		Assert.assertEquals(true, leonidas.puedoAtacar(lancer));
		
		leonidas.setEnergia(0);
		Assert.assertEquals(false, leonidas.puedoAtacar(lancer));
		leonidas.beberPoción();
		Assert.assertEquals(true, leonidas.puedoAtacar(lancer));
	}

	@Test
	public void equiparArquero() throws Exception
	{
		Unidad legolas = new Arquero();
		legolas = new Puñal(legolas);
		legolas = new Escudo(legolas);
		legolas = new Capa(legolas);
		
		Assert.assertEquals(20, legolas.getFlechas());
		legolas.setFlechas(0);
		Assert.assertEquals(0, legolas.getFlechas());
		legolas.recargarFlechas();
		Assert.assertEquals(6, legolas.getFlechas());
	}
	
	@Test
	public void equiparLancero() throws Exception
	{
		Unidad lancer = new Lancero();
		lancer = new Puñal(lancer);
		lancer = new Escudo(lancer);
		lancer = new Capa(lancer);
		
		Assert.assertEquals(25, lancer.getDaño());
		Assert.assertEquals(-3, lancer.getDefensa());
	}
	
	@Test
	public void equiparMultiplesItems() throws Exception
	{
		Unidad lancer = new Lancero();
		lancer = new Puñal(lancer);
		lancer = new Escudo(lancer);
		lancer = new Capa(lancer);
		
		try
		{
			lancer = new Puñal(lancer);
		}
		catch (Exception ex)
		{
			Assert.assertEquals(ex.getMessage(), "Ya tiene un puñal equipado!");
		}
		
		try
		{
			lancer = new Capa(lancer);
		}
		catch (Exception ex)
		{
			Assert.assertEquals(ex.getMessage(), "Ya tiene una capa equipada!");
		}
		
		try
		{
			lancer = new Escudo(lancer);
		}
		catch (Exception ex)
		{
			Assert.assertEquals(ex.getMessage(), "Ya tiene un escudo equipado!");
		}
	}
}
