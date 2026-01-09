package pk1.CP;

import java.io.*;
import java.util.*;

public class Tree_coloring_EASY {

    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    static void DFS(int v, int par, List<List<Integer>> adj, int[] depth) {
        for(int x : adj.get(v)) {
            if(x == par) continue;
            depth[x] = depth[v] + 1;
            DFS(x, v, adj, depth);
        }
    }
    static void solve(FastScanner fs) {
        int n = fs.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n-1; i++) {
            int a = fs.nextInt()-1;
            int b = fs.nextInt()-1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] depth = new int[n];
        boolean[] vis = new boolean[n];
        DFS(0, -1, adj, depth);

        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++) cnt.put(depth[i], cnt.getOrDefault(depth[i], 0) + 1);

        int ans = 0;
        for(int val : cnt.values()) ans = Math.max(ans, val);

        for(int i = 0; i < n; i++) {
            int deg = adj.get(i).size();
            if(i != 0) deg--;
            if(deg == ans) {
                System.out.println(ans+1);
                return;
            }
        }
        System.out.println(ans);

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
