package eu.sirotin.example.optional4;

import com.sun.istack.internal.Nullable;

import java.util.Optional;

/**
 * Simulates essential behavior of rain watter dispenser with quality control.
 * The dispenser get water only if water tank is filles and water is clean.
 */
public class RainWaterDispenser implements IRainWaterDispenser{
    @Nullable private RainWater rainWater;

    @Override
    public void setAvailability(@Nullable RainWater rainWater) {
        this.rainWater = rainWater;
    }

    @Override
    public Optional<RainWater> getRainWater() {
        return Optional.ofNullable(rainWater).filter(RainWater::isClean);
    }
    
}
