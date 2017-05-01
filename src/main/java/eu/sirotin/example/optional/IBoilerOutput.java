package eu.sirotin.example.optional;

import java.util.Optional;

public interface IBoilerOutput {
	
	Optional<CupOfWater> getCupOfWater();
	
	Optional<CupOfBoiledWater> getCupOfBoiledWater();

}

