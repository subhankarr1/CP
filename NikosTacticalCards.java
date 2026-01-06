package pk1.CP;
import java.util.*;

public class NikosTacticalCards {

    public static void test_cases(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for(int i = 1; i <= n; i++) a[i] = sc.nextInt();
        for(int i = 1; i <= n; i++) b[i] = sc.nextInt();
        long pr = 0, pb = 0;
        for(int i = 1; i <= n; i++) {
            long red = Math.max(pr - a[i], b[i] - pb);
            long blue = Math.min(pb - a[i], b[i] - pr);
            pr = red;
            pb = blue;
        }
        System.out.println(pr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) test_cases(sc);
    }
}
