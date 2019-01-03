import java.util.Scanner;

/**
 * Created by tjrwl on 2017-12-13.
 */
public class N_9095 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=0; i<N; i++){
            int V = Integer.parseInt(scan.nextLine());
            solve(V);
        }

    }
    static void solve(int V){
        int[] DP = new int[V+1];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        for(int i=4; i<=V; i++){
            DP[i] = DP[i-1]+DP[i-2]+DP[i-3];
        }
        System.out.println(DP[V]);
    }
}
