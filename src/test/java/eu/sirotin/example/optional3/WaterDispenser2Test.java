package eu.sirotin.example.optional3;

import eu.sirotin.example.optional.CupOfWater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author vsirotin
 */
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