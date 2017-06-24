package eu.sirotin.example.optional5;

import eu.sirotin.example.optional4.RainWater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RainWaterCleanerTest {
    private IRainWaterCleaner rainWaterDispenser;

    @Before
    public void setUp() throws Exception {
        rainWaterDispenser = new RainWaterCleaner();
    }

    @Test
    public void testRainWaterAvailableAndClean() {
        rainWaterDispenser.setAvailability(new RainWater(true));
        assertTrue(rainWaterDispenser.getCleanedWater().isPresent());
    }
    
 
    @Test
    public void testWaterNotAvailable() {
        rainWaterDispenser.setAvailability(null);
        assertFalse(rainWaterDispenser.getCleanedWater().isPresent());
    }
    
    @Test
    public void testRainWaterAvailableNotClean() {
        rainWaterDispenser.setAvailability(new RainWater(false));
        assertTrue(rainWaterDispenser.getCleanedWater().isPresent());
    }
}