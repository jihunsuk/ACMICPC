import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_2178 {
    static int edge[][];
    static int map[][];
    static boolean b[][];
    static int N;
    static int M;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        edge = new int[N+2][M+2];
        map = new int[N+2][M+2];
        b = new boolean[N+2][M+2];
        scan.nextLine();
        for(int i=1; i<=N; i++){
            String str = scan.nextLine();
            for(int j=1; j<=M; j++){
                edge[i][j] = (int)str.charAt(j-1)-48;
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        map[1][1] = 1;
        bfs();
    }
    static void bfs(){
        Queue<edge> q = new LinkedList<edge>();
        b[1][1] = true;
        q.add(new edge(1, 1));
        while(!q.isEmpty()){
            edge e = q.remove();
            int H = e.getH();
            int W = e.getW();
            if(H+1 <= N && edge[H+1][W] == 1 && !b[H+1][W]){
                b[H+1][W] = true;
                q.add(new edge(H+1, W));
                if (map[H+1][W] > map[H][W]+1)
                    map[H+1][W] = map[H][W]+1;
            }
            if(H-1 >= 1 && edge[H-1][W] == 1 && !b[H-1][W]){
                b[H-1][W] = true;
                q.add(new edge(H-1, W));
                if (map[H-1][W] > map[H][W]+1)
                    map[H-1][W] = map[H][W]+1;
            }
            if(W+1 <= M && edge[H][W+1] == 1 && !b[H][W+1]){
                b[H][W+1] = true;
                q.add(new edge(H, W+1));
                if (map[H][W+1] > map[H][W]+1)
                    map[H][W+1] = map[H][W]+1;
            }
            if(W-1 >= 1 && edge[H][W-1] == 1 && !b[H][W-1]){
                b[H][W+1] = true;
                q.add(new edge(H, W-1));
                if (map[H][W-1] > map[H][W]+1)
                    map[H][W-1] = map[H][W]+1;
            }
        }
        System.out.println(map[N][M]);
    }
}

class edge{
    private int H;
    private int W;
    public edge(int h, int w){
        this.H = h;
        this.W = w;
    }
    public int getH(){
        return H;
    }
    public int getW(){
        return W;
    }
}

