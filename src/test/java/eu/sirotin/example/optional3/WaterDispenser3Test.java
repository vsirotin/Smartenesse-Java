package eu.sirotin.example.optional3;

import eu.sirotin.example.optional.CupOfWater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * @author vsirotin
 */
public class WaterDispenser3Test {
    private IWaterDispenser waterDispenser;

    @Before
    public void setUp() throws Exception {
        waterDispenser = new WaterDispenser3();
    }

    @Test
    public void testMainAvailable() {
        waterDispenser.setAvailability(new CupOfWater());
        assertNotNull(waterDispenser.getCupOfWater());
    }


    @Test  (expected = IllegalStateException.class)
    public void testMainNotAvailable() {
        waterDispenser.setAvailability(null);
        waterDispenser.getCupOfWater();
        fail("This code line must be not reached");
    }
}