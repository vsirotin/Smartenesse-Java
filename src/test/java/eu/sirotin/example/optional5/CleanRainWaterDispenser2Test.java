package eu.sirotin.example.optional5;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import eu.sirotin.example.optional4.RainWater;


public class CleanRainWaterDispenser2Test {
    private ICleanRainWaterDispenser rainWaterDispenser;

    @Before
    public void setUp() throws Exception {
        rainWaterDispenser = new CleanRainWaterDispenser2();
    }

    @Test
    public void testRainWaterAvailableAndClean() {
        rainWaterDispenser.setAvailability(new RainWater(true));
        assertTrue(rainWaterDispenser.getCleanableRainWater().isPresent());
    }
    
 
    @Test
    public void testWaterNotAvailable() {
        rainWaterDispenser.setAvailability(null);
        assertTrue(rainWaterDispenser.getCleanableRainWater().isPresent());
    }
    
    @Test
    public void testRainWaterAvailableNotClean() {
        rainWaterDispenser.setAvailability(new RainWater(false));
        assertTrue(rainWaterDispenser.getCleanableRainWater().isPresent());
    }
}