package pk1.CP;

import java.io.*;
import java.util.*;

public class Tree_coloring_HARD {

    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);


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

        List<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        order.add(0);
        int[] depth = new int[n];
        int[] par = new int[n];
        Arrays.fill(par, -1);
        List<List<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++) nodes.add(new ArrayList<>());

        //bfs
        while(!q.isEmpty()) {
            int v = q.poll();
            for(int x : adj.get(v)) {
                if(par[x] == -1 && x != 0) {
                    par[x] = v;
                    depth[x] = depth[v] + 1;
                    nodes.get(depth[x]).add(x);
                    q.add(x);
                    order.add(x);
                }
            }
        }
        int[] turn = new int[n]; //number assigned to node i, 0th -> 0
        for(int i = 1; i < n; i++)
        {
            Set<Integer> s = new TreeSet<>();   //set of available numbers at this level
            int sz = nodes.get(i).size();
            for(int j = 0; j <= sz; j++) s.add(j);

            for(int j = 0; j < sz; j++) {
                int node = nodes.get(i).get((j+1) % sz); // circular shit par[i] -- child[i]
                turn[node] = turn[par[nodes.get(i).get(j)]];
                s.remove(turn[par[nodes.get(i).get(j)]]);
            }

            for(int node : nodes.get(i)) {
                if(turn[node] == turn[par[node]]) { // if turn == par do something
                    turn[node] = s.iterator().next();
                    s.remove(turn[node]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) ans.add(new ArrayList<>());
        int an = 0;
        for(int i = 0; i < n; i++) {
            ans.get(turn[i]).add(i);
            an = Math.max(an, turn[i] + 1);
        }
        System.out.println(an);
        for(int i = 0; i < an; i++) {
            System.out.print(ans.get(i).size() + " ");
            for(int x : ans.get(i)) {
                System.out.print((x+1) + " ");
            }
            System.out.println();
        }
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
