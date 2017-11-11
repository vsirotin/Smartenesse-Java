package eu.sirotin.example.optional2;

import eu.sirotin.example.optional.CupOfBoiledWater;
import eu.sirotin.example.optional.CupOfWater;

import java.util.Optional;


/**
 * Simulates essential behaviour of water boiler.
 * The boiler gets cols watter if water available. It get boiled water if cold water and power both available.
 */
public class Boiler2 implements IBoiler2 {
	
	private CupOfWater water;
	private boolean powerAvailable;
	

	@Override
	public void setAvailability(CupOfWater water, boolean powerAvailable) {
		this.water = water;
		this.powerAvailable = powerAvailable;
	}

	@Override
	public Optional<CupOfWater> getCupOfWater() {
		return Optional.ofNullable(water);
	}

	@Override
	public Optional<CupOfBoiledWater> getCupOfBoiledWater() {
		if(!powerAvailable)return Optional.empty();
		return getCupOfWater().map(CupOfWater::boil);
		//Alternative statement: return getCupOfWater().map(cupOfWater->cupOfWater.boil());
	}
}
