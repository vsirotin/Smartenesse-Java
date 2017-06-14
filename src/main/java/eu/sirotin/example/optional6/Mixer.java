package eu.sirotin.example.optional6;

import java.util.Optional;

import eu.sirotin.example.optional5.CleanRainWaterDispenser1;
import eu.sirotin.example.optional5.CleanableRainWater;

public class Mixer extends CleanRainWaterDispenser1 implements IMixer{
	
	private MixedCleanableRainWater result = null;

	@Override
	public Optional<MixedCleanableRainWater> getMixedWater() {
		super.getCleanableRainWater().ifPresent(this::mix);
		return Optional.ofNullable(result);

	}
	
	private void mix(CleanableRainWater cleanableRainWater) {
		result = new MixedCleanableRainWater(cleanableRainWater);
	}

}
