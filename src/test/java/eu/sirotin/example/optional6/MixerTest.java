package eu.sirotin.example.optional6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import eu.sirotin.example.optional4.RainWater;


public class MixerTest {
    private IMixer mixer;

    @Before
    public void setUp() throws Exception {
        mixer = new Mixer();
    }

    @Test
    public void testRainWaterAvailableAndClean() {
        mixer.setAvailability(new RainWater(true));
        assertTrue(mixer.getMixedWater().isPresent());
    }
    
 
    @Test
    public void testWaterNotAvailable() {
        mixer.setAvailability(null);
        assertFalse(mixer.getMixedWater().isPresent());
    }
    
    @Test
    public void testRainWaterAvailableNotClean() {
        mixer.setAvailability(new RainWater(false));
        assertTrue(mixer.getMixedWater().isPresent());
    }
    
  
}