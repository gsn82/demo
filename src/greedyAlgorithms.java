import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class greedyAlgorithms {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};

        System.out.println(maxNumberFromDigits(digits));
        System.out.println(maxNumberFromDigitsLambda(digits));


        int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(stations, 400));

    }

    private static String maxNumberFromDigits(int[] digits) {
        Arrays.sort(digits);
        String result = "";

        for (int i = digits.length - 1; i >= 0; i--)
            result += digits[i];

        return result;
    }

    private static String maxNumberFromDigitsLambda(int[] digits) {
        return String.join("", Arrays.stream(digits).boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    // returns -1 if it's impossible to ge from A to B
    public static int minStops(int[] stations, int capactity) {
        int result = 0; // оптимальное количество остановок
        int currentStop=0;

        while (currentStop < stations.length-1) {
            int nextStop = currentStop;  // будет храниться индекс заправки
            while (nextStop < stations.length -1 &&
                    stations[nextStop+1]-stations[currentStop]<=  capactity) {
                nextStop++;
            }
            if (currentStop == nextStop){  // не можем доехать до следующей заправки
                return -1;
            }
            if (nextStop <stations.length-1){
                result++;
            }

            currentStop =nextStop;
        }


        return result;
    }

}
