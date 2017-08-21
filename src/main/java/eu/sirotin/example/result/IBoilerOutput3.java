package eu.sirotin.example.result;

import eu.sirotin.example.optional.CupOfBoiledWater;
import eu.sirotin.example.optional.CupOfWater;
import eu.sirotin.utils.result.Result;

public interface IBoilerOutput3 {
	
	Result<CupOfWater, String> getCupOfWater();

	Result<CupOfBoiledWater, String> getCupOfBoiledWater();

}

