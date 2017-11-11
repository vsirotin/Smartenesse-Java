package eu.sirotin.example.optional3;

import eu.sirotin.example.optional.CupOfWater;

import java.util.Optional;

/**
 * Simulates essential behavior of water dispenser with main input (rain water) and reserve (regular water pipeline).
 */
public class WaterDispenser2 implements IWaterDispenser{
     private CupOfWater mainCup;

    @Override
    public void setAvailability(CupOfWater rainWater) {
        this.mainCup = rainWater;
    }

    @Override
    public CupOfWater getCupOfWater() {
        return Optional.ofNullable(mainCup).orElseGet(CupOfWater::new);
    }
}
