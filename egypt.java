import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int den = input.nextInt();
    doSomething(num,den);
  }
  public static void doSomething(int num, int den) {
    //Do Something
    if (num==0 || den==0) {
      return;
    }
    if (den >= num) {
      int rem=den%num;
      int div=den / num;
      if (rem != 0) {
        div++;
        System.out.println(div);
        num=num*div-den;
        den=den*div;
        doSomething(num,den);
      } else {
        System.out.println(div);
      }
    } else {
      System.out.println(den);
      doSomething(num%den,den);
    }
  }
}