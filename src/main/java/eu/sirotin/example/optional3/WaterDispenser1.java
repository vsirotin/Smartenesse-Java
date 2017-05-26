package eu.sirotin.example.optional3;

import com.sun.istack.internal.Nullable;
import eu.sirotin.example.optional.CupOfWater;

import java.util.Optional;



/**
 * @author vsirotin
 */
public class WaterDispenser1  implements IWaterDispenser{
    @Nullable private CupOfWater mainCup;

    @Override
    public void setAvailability(@Nullable CupOfWater firstPortion) {
        this.mainCup = firstPortion;
    }

    @Override
    public CupOfWater getCupOfWater() {
        return Optional.ofNullable(mainCup).orElse(new CupOfWater());
    }
}
