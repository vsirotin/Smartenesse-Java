package eu.sirotin.example.optional;

import java.util.Optional;

/**
 * Simulates essential behaviour of water boiler.
 * The boiler gets cols watter if water available. It get boiled water if cold water and power both available.
 */
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
		return waterAvailable
				? Optional.of(new CupOfWater())
				: Optional.empty();
	}

	@Override
	public Optional<CupOfBoiledWater> getCupOfBoiledWater() {
		if(!powerAvailable)return Optional.empty();
		return getCupOfWater().map(CupOfWater::boil);
	}
}
