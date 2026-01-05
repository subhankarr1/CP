package pk1.CP;
import java.util.*;



public class Square {

    public static void test_cases(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

         if(a == b && b== c && c== d) System.out.println("YES");
         else System.out.println("NO");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) test_cases(sc);
    }
}
