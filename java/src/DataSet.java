import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to store in itself an unchanging collection of critics
 */
class DataSet {

    /**
     * This property stores in itself an unchangeable map of critics for use in calculations
     */
    final static Map<String, Map<String, Double>> CRITICS;

    static {
        HashMap<String, Map<String, Double>> hashMap = new HashMap<String, Map<String, Double>>() {{
            put("Lisa Rose", new HashMap<String, Double>() {{
                put("Lady in the Water", 2.5);
                put("Snakes on a Plane", 3.5);
                put("Just my luck", 3.0);
                put("Superman returns", 3.5);
                put("You, Me and Dupree", 2.5);
                put("The Night Listener", 3.0);
            }});

            put("Gene Seymour", new HashMap<String, Double>() {{
                put("Lady in the Water", 3.0);
                put("Snakes on a Plane", 3.5);
                put("Just my luck", 1.5);
                put("Superman returns", 5.0);
                put("You, Me and Dupree", 3.5);
                put("The Night Listener", 3.0);
            }});
        }};

        CRITICS = Collections.unmodifiableMap(hashMap);
    }
}
