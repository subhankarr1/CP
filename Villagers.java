package pk1.CP;
import java.util.*;

public class Villagers {
    static void test_cases(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        long ans = 0L;
        for(int i = n-1; i >= 0; i-=2) ans += arr[i];
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) test_cases(sc);
    }
}
