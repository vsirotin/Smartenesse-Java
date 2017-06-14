package eu.sirotin.example.optional4;

import java.util.Optional;

import com.sun.istack.internal.Nullable;


public class RainWaterDispenser1  implements IRainWaterDispenser{
    @Nullable private RainWater rainWater;

    @Override
    public void setAvailability(@Nullable RainWater rainWater) {
        this.rainWater = rainWater;
    }

    @Override
    public Optional<RainWater> getRainWater() {
        return Optional.ofNullable(rainWater).filter(w->w.isClean());
    }
    
}
