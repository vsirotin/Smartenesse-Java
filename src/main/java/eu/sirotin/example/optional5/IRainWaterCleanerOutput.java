package eu.sirotin.example.optional5;

import eu.sirotin.example.optional.CupOfWater;

import java.util.Optional;

public interface IRainWaterCleanerOutput {
	
	Optional<CupOfWater> getCleanedWater();
}

