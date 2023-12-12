import java.util.*;

public class Main {
    public static String queries(String input) {
        String[] queries = input.split(",");
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        StringBuilder out = new StringBuilder();
        for (String query : queries) {
            String[] command = query.split(" ");
            int type = Integer.parseInt(command[0]);
            switch (type) {
                case 1:
                    int number = Integer.parseInt(command[1]);
                    s1.push(number);
                    break;
                case 2:
                    if (s2.isEmpty()) {
                        while (!s1.isEmpty()) {
                            s2.push(s1.pop());
                        }
                    }
                    if (!s2.isEmpty()) {
                        s2.pop();
                    }
                    break;
                case 3:
                    if (s2.isEmpty()) {
                        while (!s1.isEmpty()) {
                            s2.push(s1.pop());
                        }
                    }
                    if (!s2.isEmpty()) {
                        out.append(s2.peek()).append(" ");
                    }
                    break;
            }
        }
        return out.toString().trim();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String output = queries(str);
        System.out.println(output);
    }
}
