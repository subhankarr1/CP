package pk1.CP;

import java.util.*;

public class FairRemoval {
    public static void test(Scanner sc) {
        int n = sc.nextInt();
        String s = sc.next();
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') zero++;
            else one++;
        }
        int mxOperations = Math.min(n / 3, Math.min(zero, one));
        System.out.println(n - 3 * mxOperations);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) test(sc);
    }
}
