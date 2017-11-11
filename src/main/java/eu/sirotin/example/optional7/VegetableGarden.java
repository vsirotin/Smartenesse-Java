package eu.sirotin.example.optional7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author vsirotin
 */
public class VegetableGarden {

    private final List<Optional<String>>  tomatoBeds = new ArrayList<>();

    public VegetableGarden(String... harvest){
        assert harvest != null;
        assert harvest.length > 0;
        Arrays.asList(harvest).forEach(x->tomatoBeds.add(Optional.ofNullable(x)));
    }

    public List<Optional<String>> getTomatoBeds() {
        return tomatoBeds;
    }
}
