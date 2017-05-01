package eu.sirotin.example.optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Boiler1Test {
	
	private IBoiler boiler;
	
	@Before
	public void setUp() throws Exception {
		boiler = new Boiler1();
	}

	@Test
	public void testBothNotAvailable() {				
		boiler.setAvailability(false, false);
		assertFalse(boiler.getCupOfWater().isPresent());
		assertFalse(boiler.getCupOfBoiledWater().isPresent());
	}
	
	
	@Test
	public void testPowerAvailable() {						
		boiler.setAvailability(false, true);
		assertFalse(boiler.getCupOfWater().isPresent());
		assertFalse(boiler.getCupOfBoiledWater().isPresent());
	}
	
	@Test
	public void testWaterAvailable() {		
		boiler.setAvailability(true, false);
		assertTrue(boiler.getCupOfWater().isPresent());
		assertFalse(boiler.getCupOfBoiledWater().isPresent());
	}
	
	@Test
	public void testBothAvailable() {		
		boiler.setAvailability(true, true);
		assertTrue(boiler.getCupOfWater().isPresent());
		assertTrue(boiler.getCupOfBoiledWater().isPresent());
	}

}
