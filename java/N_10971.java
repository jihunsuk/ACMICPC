import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_10971 {
    static int[][] map;
    static int[] Co;
    static boolean[] b;
    static int n;
    static int C = 10000005;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = scan.nextInt();
            }
        }
        for(int i=1; i<=n; i++){
            dfs(i);
        }

    }

    static void dfs(int s){

    }
}
