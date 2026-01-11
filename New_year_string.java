package pk1.CP;

import java.io.*;

public class New_year_string {

    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);


    static void solve(FastScanner fs) {
        int n = fs.nextInt();
        String s = fs.next();
        if(s.contains("2025") && !s.contains("2026")) System.out.println(1);
        else System.out.println(0);
    }

    public static void main(String[] args) {
        int t = fs.nextInt();
        while (t-- > 0)
            solve(fs);
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
