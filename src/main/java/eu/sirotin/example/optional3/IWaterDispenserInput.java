package eu.sirotin.example.optional3;

import com.sun.istack.internal.Nullable;

import eu.sirotin.example.optional.CupOfWater;

public interface IWaterDispenserInput {
	
	void setAvailability(@Nullable CupOfWater rainWater);
}
