package eu.sirotin.example.optional;

import java.util.Optional;


public class Boiler1 implements IBoiler {
	
	private boolean waterAvailable;
	private boolean powerAvailable;
	

	@Override
	public void setAvailability(boolean waterAvailable, boolean powerAvailable) {
		this.waterAvailable = waterAvailable;
		this.powerAvailable = powerAvailable;
	}

	@Override
	public Optional<CupOfWater> getCupOfWater() {
		return waterAvailable ? Optional.of(new CupOfWater()) : Optional.empty();
	}

	@Override
	public Optional<CupOfBoiledWater> getCupOfBoiledWater() {
		if(!powerAvailable)return Optional.empty();
		return getCupOfWater().map(cupOfWater->cupOfWater.boil());
	}

}
