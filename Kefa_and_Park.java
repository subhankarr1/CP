package pk1.CP;
import java.util.*;

public class Kefa_and_Park {

    static List<List<Integer>> tree;
    static int n, m;
    static int[] cat;
    static int ans = 0;
    static void DFS(int parent, int node, int conseCats) {
        if(cat[node] == 1) conseCats++;
        else conseCats = 0;
        if(conseCats > m) return;
        boolean leaf = true;
        for(int i : tree.get(node)) {
            if(i != parent) {
                leaf = false;
                DFS(node, i,conseCats);
            }
        }
        if(leaf) ans++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m= sc.nextInt();
        cat = new int[n+1];
        tree = new ArrayList<>();
        for(int i = 1; i <= n; i++) cat[i] = sc.nextInt();
        for(int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        for(int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        DFS(0, 1, 0);
        System.out.println(ans);
    }
}

/*
            1
          2=c  3  4
    cat == 1
        ++
        cat > m 0;
 */