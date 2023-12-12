import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str = input.nextLine();
    int queryCount = input.nextInt();
    int[][] queries = new int[queryCount][2];
    for (int i=0; i<queryCount; i++) {
      for (int j = 0; j < 2; j++) {
        queries[i][j]=input.nextInt();
      }
    }
    String[] inputArray=str.split(" ");
    int[] answer = smallest(inputArray,queries);
    for (int x:answer) {
      System.out.print(x+" ");
    }
  }
  public static int[] smallest(String[] nums, int[][] queries) {
    //Do Something
    if (nums.length == 0) {
      return new int[0];
    }
    int[] result = new int[queries.length];
    int strLength = nums[0].length();
    int[] index = new int[1];
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->{
      for (int i = index[0]; i<strLength; i++) {
        if (nums[a].charAt(i)!= nums[b].charAt(i)) {
          return nums[b].charAt(i)-nums[a].charAt(i);
        }
      }
      return b-a;
    });
    for (int i = 0; i<queries.length; i++) {
      index[0]=strLength-queries[i][1];
      queue.clear();
      for (int j = 0; j < nums.length; j++) {
        queue.add(j);
        if (queue.size()>queries[i][0]) {
          queue.poll();
        }
      }
      result[i]=queue.poll();
    }
    return result;
  }
}