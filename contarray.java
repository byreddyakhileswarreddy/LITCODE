import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {
  public static int findmaxlen(int[] arr) {
    int maxlen = 0;
    int sum = 0;
    Map<Integer,Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        sum--;
      } else {
        sum++;
      }
      if (map.containsKey(sum)) {
        int previndex = map.get(sum);
        maxlen = Math.max(maxlen,i-previndex);
      } else {
        map.put(sum, i);
      }
    }
    return maxlen;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] str = input.nextLine().split(" ");
    int[] nums = new int[str.length];
    for (int i = 0; i < str.length; i++) {
      nums[i] = Integer.parseInt(str[i]);
    }
    int maximumlen = findmaxlen(nums);
    System.out.print(maximumlen);
  }
}