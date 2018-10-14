import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 방문할 때가 아닌 *2 +1 -1 할때 visited = true하면 1*2, 1+1 일때 뒤에꺼는 queue에 안넣어준다.
//그래서 방문할 때 visited = true 해주면 된다.
public class N_12851 {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        solve();
    }

    private static void solve() {
        int time = 0;
        int number = 0;
        boolean find = false;

        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(n,0));

        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            visited[t.n] = true;

            if(t.n == k && !find) {
                time = t.time;
                find = true;
                number = 1;
            } else if(find && t.n == k && time == t.time){
                number++;
            }

            if(t.n-1>=0) {
                if (!visited[t.n - 1]){
                    queue.add(new Pair(t.n - 1, t.time + 1));
                }
            }
            if(t.n*2<=100000) {
                if (!visited[t.n * 2]){
                    queue.add(new Pair(t.n * 2, t.time + 1));
                }
            }
            if(t.n+1<=100000) {
                if (!visited[t.n + 1]){
                    queue.add(new Pair(t.n + 1, t.time + 1));
                }
            }

        }
        System.out.println(time);
        System.out.print(number);
    }

    private static class Pair{
        private int time = 0;
        private int n = 0;
        public Pair(int n,int time) {
            this.time = time;
            this.n = n;
        }
    }
}


