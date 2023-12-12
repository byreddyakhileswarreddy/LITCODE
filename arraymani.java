import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n + 1];
        int qc = sc.nextInt();
        for (int i = 0; i < qc; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            for (int j = start; j <= end; j++) {
                array[j] += value;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int k = 1; k <= n; k++) {
            if (array[k] > max) {
                max = array[k];
            }
        }
        System.out.println(max);
    }
}
