package pk1.CP;

import java.util.*;

public class Drifting_away {
    static void test_cases(Scanner sc) {
        String s = sc.next();
        int n = s.length();
        int l = 0, star = 0, r = 0;
        for(char c : s.toCharArray()) {
            if(c == '<') l++;
            else if (c == '*') star++;
            else r++;
         }
        String c = "<".repeat(l) + "*".repeat(star) + ">".repeat(r);
        if(star > 1 || !s.equals(c)) System.out.println(-1);
        else System.out.println(Math.max(l+star, r+star));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) test_cases(sc);
    }
}

