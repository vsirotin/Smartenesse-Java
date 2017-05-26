package eu.sirotin.example.optional2;

import eu.sirotin.example.optional.CupOfWater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Boiler2Test {
	
	private IBoiler2 boiler;
	
	@Before
	public void setUp() throws Exception {
		boiler = new Boiler2();
	}

	@Test
	public void testBothNotAvailable() {				
		boiler.setAvailability(null, false);
		assertFalse(boiler.getCupOfWater().isPresent());
		assertFalse(boiler.getCupOfBoiledWater().isPresent());
	}
	
	
	@Test
	public void testPowerAvailable() {						
		boiler.setAvailability(null, true);
		assertFalse(boiler.getCupOfWater().isPresent());
		assertFalse(boiler.getCupOfBoiledWater().isPresent());
	}
	
	@Test
	public void testWaterAvailable() {		
		boiler.setAvailability(new CupOfWater(), false);
		assertTrue(boiler.getCupOfWater().isPresent());
		assertFalse(boiler.getCupOfBoiledWater().isPresent());
	}
	
	@Test
	public void testBothAvailable() {		
		boiler.setAvailability(new CupOfWater(), true);
		assertTrue(boiler.getCupOfWater().isPresent());
		assertTrue(boiler.getCupOfBoiledWater().isPresent());
	}
}
