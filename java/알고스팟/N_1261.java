import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_1261 {
    static int[][] map;
    static int[][] distance;
    static int[] toX = {1, 0, -1, 0};
    static int[] toY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = reader.readLine().split(" ");
        final int M = Integer.parseInt(input[0]);
        final int N = Integer.parseInt(input[1]);
        map = new int[N][M];
        distance = new int[N][M];

        for(int i=0; i<N; i++){
            char[] c = reader.readLine().toCharArray();
            for(int j=0; j<c.length; j++){
                map[i][j] = c[j]-48;
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;
        Queue<n> q = new LinkedList<n>();
        q.add(new n(0, 0));
        while(!q.isEmpty()){
            n current = q.poll();
            int j = current.y;
            int k = current.x;

            for(int i=0; i<toX.length; i++){
                int nextY = j+toY[i];
                int nextX = k+toX[i];
                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N){
                    if(map[nextY][nextX] == 0 && distance[nextY][nextX] > distance[j][k]){
                        distance[nextY][nextX] = distance[j][k];
                        q.add(new n(nextX, nextY));
                    } else if (map[nextY][nextX] == 1 && distance[nextY][nextX] > distance[j][k] + 1){
                        distance[nextY][nextX] = distance[j][k] + 1;
                        q.add(new n(nextX, nextY));
                    }
                }
            }
        }
        System.out.println(distance[N-1][M-1]);
    }
}

class n {
    public int x;
    public int y;
    public n(int x, int y) {
        this.x = x;
        this.y = y;
    }
}