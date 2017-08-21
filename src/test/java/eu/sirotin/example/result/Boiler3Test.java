package eu.sirotin.example.result;

import eu.sirotin.example.optional.CupOfWater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Boiler3Test {
	
	private IBoiler3 boiler;
	
	@Before
	public void setUp() throws Exception {
		boiler = new Boiler3();
	}

	@Test
	public void testBothNotAvailable() {				
		boiler.setAvailability(null, false);
		assertFalse(boiler.getCupOfWater().isSuccess());
        boiler.getCupOfWater().ifFailure(message->assertEquals(message, Boiler3.WATER_NOT_AVAILABLE));

		assertFalse(boiler.getCupOfBoiledWater().isSuccess());
        boiler.getCupOfBoiledWater().ifFailure(message->assertEquals(message, Boiler3.BOTH_NOT_AVAILABLE));
	}
	
	
	@Test
	public void testPowerAvailable() {						
		boiler.setAvailability(null, true);
		assertFalse(boiler.getCupOfWater().isSuccess());
        boiler.getCupOfWater().ifFailure(message->assertEquals(message, Boiler3.WATER_NOT_AVAILABLE));

		assertFalse(boiler.getCupOfBoiledWater().isSuccess());
        boiler.getCupOfBoiledWater().ifFailure(message->assertEquals(message, Boiler3.WATER_NOT_AVAILABLE));
	}
	
	@Test
	public void testWaterAvailable() {		
		boiler.setAvailability(new CupOfWater(), false);
		assertTrue(boiler.getCupOfWater().isSuccess());
		assertFalse(boiler.getCupOfBoiledWater().isSuccess());
        boiler.getCupOfBoiledWater().ifFailure(message->assertEquals(message, Boiler3.POWER_NOT_AVAILABLE));
	}
	
	@Test
	public void testBothAvailable() {		
		boiler.setAvailability(new CupOfWater(), true);
		assertTrue(boiler.getCupOfWater().isSuccess());
		assertTrue(boiler.getCupOfBoiledWater().isSuccess());
	}
}
