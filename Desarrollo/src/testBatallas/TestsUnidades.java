package testBatallas;

import org.junit.Test;

import item.Escudo;

import org.junit.Assert;

import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Soldado;
import unidad.Unidad;
import unidad.Punto;

public class TestsUnidades
{
	@Test
	public void testDistancia()
	{
		Unidad soldier = new Soldado(new Punto(1, 2));
		Unidad archer = new Arquero(new Punto(4, 2));
		Unidad lancer = new Lancero(new Punto(1, 1));
		Unidad knight = new Caballero();

		archer.atacarA(soldier);
		lancer.atacarA(knight);
		knight.atacarA(archer);
		Assert.assertEquals(195, soldier.getSalud());
		Assert.assertEquals(175, knight.getSalud());
		Assert.assertEquals(50, archer.getSalud());
	}
	
	@Test
	public void testMuerte ()
	{
		Arquero archer = new Arquero(new Punto(2, 2));
		Soldado soldier = new Soldado();
		for(int i = 0; i < 5; i++) 
		{
			soldier.atacarA(archer);
		}
		Assert.assertEquals(true, archer.muerta());
		soldier.atacarA(archer);
	}

	@Test
	public void testFlechas ()
	{
		Arquero archer = new Arquero(new Punto(2, 2));
		Soldado soldier = new Soldado();
		
		for(int i = 0; i < 21; i++)
			archer.atacarA(soldier);
		
		Assert.assertEquals(0, archer.getFlechas());
		Assert.assertEquals(100, soldier.getSalud());
	}
	
	@Test
	public void testEnergia ()
	{
		Caballero knight = new Caballero(new Punto(0, 1));
		Soldado soldier = new Soldado();
		
		for(int i = 0; i < 11; i++)
			soldier.atacarA(knight);
		
		Assert.assertEquals(0, soldier.getEnergia());
		Assert.assertEquals(100,  knight.getSalud());
		
	}
	
	@Test
	public void testCaballo ()
	{
		Caballero knight = new Caballero(new Punto(0, 1));
		Soldado soldier = new Soldado();
		
		for(int i = 0; i < 4; i++)
			knight.atacarA(soldier);
		
		Assert.assertEquals(50, soldier.getSalud());
	}
	

}
