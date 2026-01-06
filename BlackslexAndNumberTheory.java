package pk1.CP;
import java.util.Arrays;
import java.util.Scanner;

public class BlackslexAndNumberTheory {

    public static void test_cases(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int ans = Math.max(a[0], a[1] - a[0]);
        System.out.println(ans);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) test_cases(sc);
    }
}
