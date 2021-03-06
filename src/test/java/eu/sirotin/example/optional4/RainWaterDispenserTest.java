package eu.sirotin.example.optional4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RainWaterDispenserTest {
    private IRainWaterDispenser rainWaterDispenser;

    @Before
    public void setUp() throws Exception {
        rainWaterDispenser = new RainWaterDispenser();
    }

    @Test
    public void testRainWaterAvailableAndClean() {
        rainWaterDispenser.setAvailability(new RainWater(true));
        assertTrue(rainWaterDispenser.getRainWater().isPresent());
        assertTrue(rainWaterDispenser.getRainWater().get().isClean());
    }
    
 
    @Test
    public void testWaterNotAvailable() {
        rainWaterDispenser.setAvailability(null);
        assertFalse(rainWaterDispenser.getRainWater().isPresent());
    }
    
    @Test
    public void testRainWaterAvailableNotClean() {
        rainWaterDispenser.setAvailability(new RainWater(false));
        assertFalse(rainWaterDispenser.getRainWater().isPresent());
    }
}