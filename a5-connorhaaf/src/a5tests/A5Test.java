package a5tests;

import static org.junit.Assert.*;

import org.junit.Test;

import a5.*;

public class A5Test {

	@Test
	public void testRedPlate() throws PlatePriceException {
		System.out.println("Testing RedPlate");
		
		Plate p = new RedPlate(null);
		
		assertEquals(Plate.Color.RED, p.getColor());
		assertEquals(1.0, p.getPrice(), 0.00001);
		assertEquals(null, p.getContents());
		assertEquals(0.0, p.getProfit(), 0.0001);
		Sushi eel_nigiri = new Nigiri(Nigiri.NigiriType.EEL);
		Sushi crab_nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		p.setContents(crab_nigiri);
		
		assertEquals(crab_nigiri, p.getContents());
		assertEquals(0.39, p.getProfit(), 0.0001);
		
		Sushi old_contents = p.removeContents();
		assertEquals(crab_nigiri, old_contents);
		assertEquals(null, p.getContents());
		
		try {
			p.setContents(eel_nigiri);
			fail("Should have raised PlatePriceException");
		}
		catch (PlatePriceException e) {
		}
		catch (Throwable e) {
			fail("Should have raised PlatePriceException");
		}
	}

	@Test
	public void testGreenPlate() throws PlatePriceException {
		System.out.println("Testing GreenPlate");
		
		Plate p = new GreenPlate(null);
		
		assertEquals(Plate.Color.GREEN, p.getColor());
		assertEquals(2.0, p.getPrice(), 0.00001);
		assertEquals(null, p.getContents());
		assertEquals(0.0, p.getProfit(), 0.0001);
		Sushi crab_nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		p.setContents(crab_nigiri);
		
		assertEquals(crab_nigiri, p.getContents());
		assertEquals(1.39, p.getProfit(), 0.0001);
		
		Sushi old_contents = p.removeContents();
		assertEquals(crab_nigiri, old_contents);
		assertEquals(null, p.getContents());

		Sushi expensive_roll = new Roll("Expensive Roll", new IngredientPortion[] {new EelPortion(10.0), new TunaPortion(10.0)});

		try {
			p.setContents(expensive_roll);
			fail("Should have raised PlatePriceException");
		}
		catch (PlatePriceException e) {
		}
		catch (Throwable e) {
			fail("Should have raised PlatePriceException");
		}
	}

	@Test
	public void testBluePlate() throws PlatePriceException {
		System.out.println("Testing BluePlate");
		
		Plate p = new BluePlate(null);
		
		assertEquals(Plate.Color.BLUE, p.getColor());
		assertEquals(4.0, p.getPrice(), 0.00001);
		assertEquals(null, p.getContents());
		assertEquals(0.0, p.getProfit(), 0.0001);
		Sushi crab_nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		p.setContents(crab_nigiri);
		
		assertEquals(crab_nigiri, p.getContents());
		assertEquals(3.39, p.getProfit(), 0.0001);
		
		Sushi old_contents = p.removeContents();
		assertEquals(crab_nigiri, old_contents);
		assertEquals(null, p.getContents());

		Sushi expensive_roll = new Roll("Expensive Roll", new IngredientPortion[] {new EelPortion(10.0), new TunaPortion(10.0)});

		try {
			p.setContents(expensive_roll);
			fail("Should have raised PlatePriceException");
		}
		catch (PlatePriceException e) {
		}
		catch (Throwable e) {
			fail("Should have raised PlatePriceException");
		}
	}

	@Test
	public void testGoldPlate() throws PlatePriceException {
		System.out.println("Testing GoldPlate");

		Plate p = null;
		try {
			p = new GoldPlate(null, 2.0);
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail("Should have thrown IllegalArgumentException");
		}
		
		p = new GoldPlate(null, 7.50);
		
		assertEquals(Plate.Color.GOLD, p.getColor());
		assertEquals(7.50, p.getPrice(), 0.00001);
		assertEquals(null, p.getContents());
		assertEquals(0.0, p.getProfit(), 0.0001);
		Sushi crab_nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		p.setContents(crab_nigiri);
		
		assertEquals(crab_nigiri, p.getContents());
		assertEquals(6.89, p.getProfit(), 0.0001);
		
		Sushi old_contents = p.removeContents();
		assertEquals(crab_nigiri, old_contents);
		assertEquals(null, p.getContents());

		Sushi expensive_roll = new Roll("Expensive Roll", new IngredientPortion[] {new EelPortion(10.0), new TunaPortion(10.0)});

		try {
			p.setContents(expensive_roll);
			fail("Should have raised PlatePriceException");
		}
		catch (PlatePriceException e) {
		}
		catch (Throwable e) {
			fail("Should have raised PlatePriceException");
		}
	}

}
