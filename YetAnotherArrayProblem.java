package pk1.CP;

import java.io.*;

public class YetAnotherArrayProblem {

    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);


    static long[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19,
            23, 29, 31, 37, 41, 43, 47, 53
    };

    static void solve() {
        int n = fs.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++)
            a[i] = fs.nextLong();


        for (long x : primes) {
            boolean ok = false;
            for (long val : a) {
                if (val % x != 0) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                out.println(x);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int t = fs.nextInt();
        while (t-- > 0)
        solve();
        out.flush();
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0 ;

        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ' && c != -1) ;
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        long nextLong() {
            long val = 0;
            int c;
            while ((c = read()) <= ' ' && c != -1) ;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        int nextInt() {
            return (int) nextLong();
        }
    }
}
