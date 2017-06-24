package eu.sirotin.example.optional6;

import eu.sirotin.example.optional5.IRainWaterCleanerOutput;

import java.util.Optional;

public interface IMixerOutput extends IRainWaterCleanerOutput {
	
	Optional<MixedWater> getMixedWater();
}

