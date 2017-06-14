package eu.sirotin.example.optional5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import eu.sirotin.example.optional4.RainWater;


public class CleanRainWaterDispenser1Test {
    private ICleanRainWaterDispenser rainWaterDispenser;

    @Before
    public void setUp() throws Exception {
        rainWaterDispenser = new CleanRainWaterDispenser1();
    }

    @Test
    public void testRainWaterAvailableAndClean() {
        rainWaterDispenser.setAvailability(new RainWater(true));
        assertTrue(rainWaterDispenser.getCleanableRainWater().isPresent());
    }
    
 
    @Test
    public void testWaterNotAvailable() {
        rainWaterDispenser.setAvailability(null);
        assertFalse(rainWaterDispenser.getCleanableRainWater().isPresent());
    }
    
    @Test
    public void testRainWaterAvailableNotClean() {
        rainWaterDispenser.setAvailability(new RainWater(false));
        assertTrue(rainWaterDispenser.getCleanableRainWater().isPresent());
    }
}