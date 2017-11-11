package eu.sirotin.example.optional7;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author vsirotin
 */
public class VegetableGardenTest {

    private static final String CANNED_FOOD = "Canned food";
    private static final String MY_GARDEN = "My garden";
    public static final String TOMATO = "Tomato";
    public static final String CUCUMBER = "Cucumber";
    private  String[] EXPECTED_RESULT;
    private VegetableGarden tomatoGarden;
    private String veg;


    @Before
    public void setUp() throws Exception {
        EXPECTED_RESULT = new String[]{"A1", "A3", "A6"};
        tomatoGarden = new VegetableGarden("A1", null, "A3", null, null, "A6");
    }

    @Test
    public void testOptionalStreJava8() {

        String[] result = tomatoGarden
                .getTomatoBeds()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toArray(String[]::new);

        assertArrayEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void testOptionalStreamJava9()  {

           String[] result = tomatoGarden
                 .getTomatoBeds()
                .stream()
                .flatMap(Optional::stream)
                .toArray(String[]::new);

        assertArrayEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void testOptionalStreamBase()  {
        Optional<String> opFilled = Optional.of("Filled");
        assertEquals(1, opFilled.stream().count());

        Optional<String> opEmpty  = Optional.empty();
        assertEquals(0, opEmpty.stream().count());
    }

    @Test
    public void testOptionalStreamIfPresentOrElse()  {
        Optional<String> optFilled = Optional.of(TOMATO);
        optFilled.ifPresentOrElse(this::setValue, this::setDefault);

        assertEquals(TOMATO, veg);

        Optional<String> optEmpty  = Optional.empty();
        optEmpty.ifPresentOrElse(this::setValue, this::setDefault);

        assertEquals(CANNED_FOOD, veg);
    }

    @Test
    public void testOptionalOr1()  {
        Optional<String> optBed1 = Optional.empty();
        Optional<String> optBed2 = Optional.of(TOMATO);
        Optional<String> optBed3 = Optional.of(CUCUMBER);
        String res1 = optBed1
                .or(()->{return optBed2;})
                .or(()->optBed3)
                .or(this::getDefault)
                .get();

        assertEquals(res1, TOMATO);
    }

    @Test
    public void testOptionalOr2()  {
        Optional<String> optBed1 = Optional.empty();
        Optional<String> optBed2 = Optional.empty();
        Optional<String> optBed3 =  Optional.empty();
        String res1 = optBed1
                .or(()->optBed2)
                .or(()->optBed3)
                .or(()->getDefault())
                .get();

        assertEquals(res1, CANNED_FOOD);
    }

    private void setValue(String s){
        veg = s;}
    private void setDefault(){
        veg = CANNED_FOOD;}

    private Optional<? extends String> getDefault(){return Optional.of(CANNED_FOOD);};

}