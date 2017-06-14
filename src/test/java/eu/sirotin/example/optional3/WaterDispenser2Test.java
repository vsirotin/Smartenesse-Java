package eu.sirotin.example.optional3;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import eu.sirotin.example.optional.CupOfWater;


public class WaterDispenser2Test {
    private IWaterDispenser waterDispenser;

    @Before
    public void setUp() throws Exception {
        waterDispenser = new WaterDispenser2();
    }

    @Test
    public void testMainAvailable() {
        waterDispenser.setAvailability(new CupOfWater());
        assertNotNull(waterDispenser.getCupOfWater());
    }


    @Test
    public void testMainNotAvailable() {
        waterDispenser.setAvailability(null);
        assertNotNull(waterDispenser.getCupOfWater());
    }
}