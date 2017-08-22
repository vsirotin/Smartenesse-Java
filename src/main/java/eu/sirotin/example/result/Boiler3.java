package eu.sirotin.example.result;

import com.sun.istack.internal.Nullable;
import eu.sirotin.example.optional.CupOfBoiledWater;
import eu.sirotin.example.optional.CupOfWater;
import eu.sirotin.utils.result.Result;



/**
 * Simulates essential behaviour of water boiler.
 * The boiler gets cols watter if water available. It get boiled water if cold water and power both available.
 * Implementation with help of Result-class.
 */
public class Boiler3 implements IBoiler3 {

	public static final String WATER_NOT_AVAILABLE = "Water not available.";
	public static final String POWER_NOT_AVAILABLE = "Power not available.";
	public static final String BOTH_NOT_AVAILABLE = WATER_NOT_AVAILABLE + " " + POWER_NOT_AVAILABLE;

	@Nullable
	private CupOfWater water;
	private boolean powerAvailable;
	

	@Override
	public void setAvailability(@Nullable CupOfWater water, boolean powerAvailable) {
		this.water = water;
		this.powerAvailable = powerAvailable;
	}

	@Override
	public Result<CupOfWater, String> getCupOfWater() {
		return water == null
			? Result.failure(WATER_NOT_AVAILABLE)
			: Result.success(water);
	}

	@Override
	public Result<CupOfBoiledWater, String> getCupOfBoiledWater() {
		Result<CupOfWater, String> resultStep1 = getCupOfWater();
		return resultStep1.isSuccess()
				? powerAvailable
					? Result.success(resultStep1.getSuccess().boil())
					: Result.failure(POWER_NOT_AVAILABLE)
				: powerAvailable
					? Result.failure(WATER_NOT_AVAILABLE)
					: Result.failure(BOTH_NOT_AVAILABLE);
	}
}
