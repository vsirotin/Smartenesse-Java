package eu.sirotin.example.optional4;



import java.util.Optional;

/**
 * Simulates essential behavior of rain watter dispenser with quality control.
 * The dispenser get water only if water tank is filles and water is clean.
 */
public class RainWaterDispenser implements IRainWaterDispenser{
    private RainWater rainWater;

    @Override
    public void setAvailability( RainWater rainWater) {
        this.rainWater = rainWater;
    }

    @Override
    public Optional<RainWater> getRainWater() {
        return Optional.ofNullable(rainWater).filter(RainWater::isClean);
    }
    
}
