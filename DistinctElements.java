package pk1.CP;
import java.util.*;


public class DistinctElements {
    public static void test_cases(Scanner sc){
        int n = sc.nextInt();
        long[] b = new long[n+1];
        b[0] = 0;
        for(int i = 1; i <= n; i++) {
            b[i] = sc.nextLong();
        }
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            long diff = b[i+1] - b[i];
            if(i - diff >= 0) {
                a[i] = a[(int)(i - diff)];
            } else {
                a[i] = i + 1;
            }
        }
        for(int x: a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) test_cases(sc);
    }
}
