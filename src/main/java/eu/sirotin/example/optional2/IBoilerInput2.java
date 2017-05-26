package eu.sirotin.example.optional2;

import com.sun.istack.internal.Nullable;
import eu.sirotin.example.optional.CupOfWater;

public interface IBoilerInput2 {
	
	void setAvailability(@Nullable CupOfWater waterAvailable, boolean powerAvailable);
}
