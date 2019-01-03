import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//숨바꼭질3   2배로이동할떄는 시간이 0이기떄문에 오른쪽보다 2배를 먼저 q에 넣음으로 해결

public class N_13549{
    static int n,k;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[100001];
        solve();
    }

    private static void solve() {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(n,0));
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            if(t.n==k) {
                System.out.println(t.time);
                break;
            }
            if(visited[t.n]) continue;
            visited[t.n] = true;
            // 1) x-1로 이동
            if(t.n-1>=0)
                if(!visited[t.n-1]) queue.add(new Pair(t.n-1,t.time+1));
            // 3) x*2로 이동
            if(t.n*2<=100000)
                if(!visited[t.n*2]) queue.add(new Pair(t.n*2,t.time));
            // 2) x+1로 이동
            if(t.n+1<=100000)
                if(!visited[t.n+1]) queue.add(new Pair(t.n+1,t.time+1));
        }
    }

    static class Pair{
        private int time = 0;
        private int n = 0;
        public Pair(int n,int time) {
            this.time = time;
            this.n = n;
        }
    }
}
