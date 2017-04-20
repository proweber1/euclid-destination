import java.util.*;

import static java.lang.Math.*;

/**
 * Class for calculating the distance between two users using
 * the Euclidean distance estimation algorithm
 */
public class Critics {

    /**
     * This class encapsulates the algorithm for estimating the Euclidean distance
     */
    class EuclidDestination {
        private final Map<String, Map<String, Double>> prefs;
        private final String person1;
        private final String person2;

        /**
         * @param prefs Date set that contains the ratings of all critics
         * @param person1 The name of the first critic
         * @param person2 The name of the second critic
         */
        EuclidDestination(Map<String, Map<String, Double>> prefs, String person1, String person2) {
            this.prefs = prefs;
            this.person1 = person1;
            this.person2 = person2;
        }

        /**
         * This method makes an estimate of the Euclidean distance between two persons
         *
         * @return Distance in interests between two persons
         */
        double simDistance() {
            double squareSum = prefs.get(person1)
                    .entrySet()
                    .stream()
                    .filter(entry -> prefs.get(person2).containsKey(entry.getKey()))
                    .mapToDouble(this::square)
                    .sum();

            return 1 / (1 + squareSum);
        }

        /**
         * The auxiliary method which considers the square difference of estimates of critics
         *
         * @param entry The film for which both critics voted
         * @return The difference of estimates
         */
        private double square(Map.Entry<String, Double> entry) {
            final double ratingFromPerson1 = prefs.get(person1).get(entry.getKey());
            final double ratingFromPerson2 = prefs.get(person2).get(entry.getKey());

            return pow(ratingFromPerson1 - ratingFromPerson2, 2);
        }
    }

    /**
     * @param args Console arguments
     */
    public static void main(String[] args) {
        Map<String, Map<String, Double>> critics = DataSet.CRITICS;

        final Critics.EuclidDestination calc = new Critics().new EuclidDestination(critics, "Lisa Rose", "Gene Seymour");
        double calcResult = calc.simDistance();

        System.out.println(calcResult);
    }
}
