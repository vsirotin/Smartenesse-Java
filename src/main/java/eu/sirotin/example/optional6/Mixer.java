package eu.sirotin.example.optional6;

import eu.sirotin.example.optional.CupOfWater;
import eu.sirotin.example.optional5.RainWaterCleaner;

import java.util.Optional;

/**
 * Simulates essential behavior of water-mixer.
 * The mixer get mixed water if rain water is available.
 */
public class Mixer extends RainWaterCleaner implements IMixer{
	
	private MixedWater result = null;

	@Override
	public Optional<MixedWater> getMixedWater() {
		super.getCleanedWater().ifPresent(this::mix);
		return Optional.ofNullable(result);

	}
	
	private void mix(CupOfWater water) {
		result = new MixedWater(water);
	}

}
