package eu.sirotin.example.optional6;

import java.util.Optional;

import eu.sirotin.example.optional5.ICleanRainWaterDispenserOutput;

public interface IMixerOutput extends ICleanRainWaterDispenserOutput{
	
	Optional<MixedCleanableRainWater> getMixedWater();
}

