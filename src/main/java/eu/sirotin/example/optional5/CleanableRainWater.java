package eu.sirotin.example.optional5;

import eu.sirotin.example.optional4.RainWater;

public class CleanableRainWater extends RainWater {
	
	public CleanableRainWater(RainWater rainWater) {
		super(true);
	}
	
	public CleanableRainWater() {
		super(true);
	}

}
