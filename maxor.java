import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for array elements separated by spaces
        System.out.println("Enter the array elements separated by spaces:");
        String[] elements = scanner.nextLine().split(" ");
        int[] nums = new int[elements.length];

        // Convert string elements to integers
        for (int i = 0; i < elements.length; i++) {
            nums[i] = Integer.parseInt(elements[i]);
        }

        // Take user input for integer k
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Call the maximumOr method and print the result
        long result = maximumOr(nums, k);
        System.out.println("Output: " + result);
    }

    // maximumOr method implementation
    public static long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] suf = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            suf[i] = suf[i + 1] | nums[i];
        }
        long ans = 0, pre = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, pre | (1L * nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return ans;
    }
}
