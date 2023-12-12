import java.util.*;

public class Main {
    public static int clumsyFactorial(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 6;
        }
        int res = n * (n - 1) / (n - 2) + (n - 3);
        for (int i = n - 4; i >= 1; i -= 4) {
            if (i - 2 > 0) {
                res -= i * (i - 1) / (i - 2);
            } else {
                res -= i * (i - 1);
            }
            if (i - 3 > 0) {
                res += (i - 3);
            }
        }
        return res - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = clumsyFactorial(num);
        System.out.println(result);
    }
}
