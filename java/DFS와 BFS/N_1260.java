import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class N_1260 {
    static int n, m;
    static boolean[] b;
    static boolean[][] edge;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int start = scan.nextInt();

        b = new boolean[n+1];
        edge = new boolean[n+1][n+1];

        for(int i=0; i<m; i++){
            int H = scan.nextInt();
            int W = scan.nextInt();
            edge[H][W] = true;
            edge[W][H] = true;
        }
        dfs(start, b);
        b = new boolean[n+1];
        System.out.println();
        bfs(start, b);
    }
    static void bfs(int startN, boolean[] b){
        Queue<Integer> q = new LinkedList<Integer>();
        b[startN] = true;
        q.add(startN);
        while (!q.isEmpty()) {
            int here = q.remove();
            System.out.print(here + " ");
            for (int there = 1; there <= n; there++) {
                if (b[there] || (!edge[here][there])) continue;
                b[there] = true;
                q.add(there);
            }
        }
    }
    static void dfs(int startN, boolean[] b){
        b[startN] = true;
        for(int i=1; i<=n; i++){
            if(b[i] || !edge[startN][i])
                continue;
            dfs(i, b);
        }
    }

}
