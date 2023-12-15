import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UniqueQuadrupletsSum {
    public static List<List<Integer>> findQuadruplets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

                while (j < n - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            while (i < n - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the array of integers separated by spaces:");
        String[] inputArray = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        List<List<Integer>> quadruplets = findQuadruplets(nums, target);

        System.out.println("Output:");
        for (List<Integer> quad : quadruplets) {
            // Print each element separated by a space
            for (int num : quad) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
