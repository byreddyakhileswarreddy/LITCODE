//contest1
import java.util.Arrays;
import java.util.Scanner;

public class SweetnessTarget {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target sweetness level: ");
        int targetSweetness = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the sweetness of each candy (space-separated): ");
        String candiesInput = scanner.nextLine();
        String[] candiesInputArray = candiesInput.split(" ");

        int[] candies = Arrays.stream(candiesInputArray)
                              .mapToInt(Integer::parseInt)
                              .toArray();

        int steps = findStepsToTarget(candies, targetSweetness);

        System.out.println("Number of steps needed to reach the target sweetness: " + steps);
    }

    private static int findStepsToTarget(int[] candies, int targetSweetness) {
        Arrays.sort(candies);

        int steps = 0;

        while (candies[0] < targetSweetness) {
            int newSweetness = candies[0] + 2 * candies[1];
            candies = combineCandies(candies, newSweetness);
            steps++;
        }

        return steps;
    }

    private static int[] combineCandies(int[] candies, int newSweetness) {
        int[] updatedCandies = new int[candies.length - 1];
        updatedCandies[0] = newSweetness;

        for (int i = 1; i < candies.length - 1; i++) {
            updatedCandies[i] = candies[i + 1];
        }

        Arrays.sort(updatedCandies);

        return updatedCandies;
    }
}
