package eu.sirotin.example.optional5;

import java.util.Optional;

import com.sun.istack.internal.Nullable;

import eu.sirotin.example.optional4.RainWater;


public class CleanRainWaterDispenser1  implements ICleanRainWaterDispenser{
    @Nullable private RainWater rainWater;

    @Override
    public void setAvailability(@Nullable RainWater rainWater) {
        this.rainWater = rainWater;
    }

    @Override
    public Optional<CleanableRainWater> getCleanableRainWater() {
        return Optional.ofNullable(rainWater).flatMap(w->Optional.of(new CleanableRainWater(w)));
    }
    
}
