package eu.sirotin.example.optional4;

import eu.sirotin.example.optional.CupOfWater;

public class RainWater extends CupOfWater {
	
	private final boolean clean;
	
	public RainWater(boolean clean) {
		this.clean = clean;
	}

	public boolean isClean() {
		return clean;
	}

}
