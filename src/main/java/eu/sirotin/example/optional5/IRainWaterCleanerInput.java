package eu.sirotin.example.optional5;

import com.sun.istack.internal.Nullable;
import eu.sirotin.example.optional4.RainWater;

public interface IRainWaterCleanerInput {
	
	void setAvailability(@Nullable RainWater rainWater);
}
