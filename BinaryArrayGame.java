package pk1.CP;
import java.util.*;

public class BinaryArrayGame {
    public static void test_cases(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0 ; i < n; ++i) a[i] = sc.nextInt();
        System.out.println((a[0] == 1 || a[n-1] == 1) ? "ALICE" : "BOB");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) test_cases(sc);
    }
}
