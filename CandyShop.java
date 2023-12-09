import java.util.Scanner;
//alice bob contest 1
public class CandyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sum of budgets for Alice and Bob: ");
        int totalBudget = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the prices of candies (space-separated): ");
        String[] candiesInput = scanner.nextLine().split(" ");
        int[] candyPrices = new int[candiesInput.length];
        for (int i = 0; i < candiesInput.length; i++) {
            candyPrices[i] = Integer.parseInt(candiesInput[i]);
        }
        int[] indices = findCandiesForBudget(candyPrices, totalBudget);
        System.out.println("The two candies that meet the criteria are at indices: " + indices[0] + " and " + indices[1]);
    }
    private static int[] findCandiesForBudget(int[] prices, int totalBudget) {
        int[] indices = new int[2];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] + prices[j] == totalBudget) {
                    indices[0] = i + 1;
                    indices[1] = j + 1;
                    return indices;
                }
            }
        }
        System.out.println("No candies found within the total budget.");
        return indices;
    }
}
