package eu.sirotin.example.optional5;

import eu.sirotin.example.optional.CupOfWater;
import eu.sirotin.example.optional4.RainWater;

import java.util.Optional;

/**
 * Simulates essential behavior of rain water cleaner.
 * The cleaner get cleaned water as output if rain watter filled in device.
 */
public class RainWaterCleaner implements IRainWaterCleaner {
    private RainWater rainWater;

    @Override
    public void setAvailability(RainWater rainWater) {
        this.rainWater = rainWater;
    }

    @Override
    public Optional<CupOfWater> getCleanedWater() {
        return Optional.ofNullable(rainWater).flatMap(w->Optional.of(new CupOfWater()));
    }
    
}
