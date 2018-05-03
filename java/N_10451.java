import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_10451 {
    static boolean[] b;
    static int N;
    static int[][] map;
    static int c;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i=0; i<T; i++){
            N = scan.nextInt();
            map = new int[N+1][N+1];
            for(int j=1; j<=N; j++){
                int v = scan.nextInt();
                map[j][v] = 1;
            }
            c= 0;
            search();
        }
    }
    static void search(){
        b = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!b[i])
                bfs(i);
        }
        System.out.println(c);
    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        b[v] = true;
        while(!q.isEmpty()){
            int a = q.remove();
            for(int i=1; i<=N; i++){
                if(!b[i] && map[a][i] == 1){
                    q.add(i);
                    b[i] = true;
                } else if(b[i] && map[a][i] == 1){
                    c++;
                }
            }
        }

    }
}
