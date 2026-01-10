package pk1.CP;
import java.util.*;

public class Even_larger {

    static void test_cases(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        long ans = 0L;
        if(arr[0] > arr[1]) {
            ans += arr[0] - arr[1];
            arr[0] = arr[1];
        }
        for(int i = 2; i < n; i+=2) {
            int x = arr[i-1] - arr[i-2];
            if(i < n-1) x = Math.min(x, arr[i+1]);
            if(arr[i] > x) {
                ans += arr[i] - x;
                arr[i] = x;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) test_cases(sc);
    }
}

// 2 3 4 5 5
