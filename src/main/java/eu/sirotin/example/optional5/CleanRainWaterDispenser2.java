package eu.sirotin.example.optional5;

import java.util.Optional;


public class CleanRainWaterDispenser2  extends CleanRainWaterDispenser1 implements ICleanRainWaterDispenser{

    @Override
    public Optional<CleanableRainWater> getCleanableRainWater() {
        return Optional.of(super.getCleanableRainWater().orElse(new CleanableRainWater()));
    }	
    
}
