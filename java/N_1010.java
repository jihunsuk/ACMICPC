import java.util.Scanner;

/**
 * Created by tjrwl on 2017-11-09.
 */
public class N_1010 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[][] DP = new int[30][30];
        DP[1][1] = 1;
        DP[2][2] = 1;
        DP[2][1] = 2;
        for(int i=0; i<30; i++){
            DP[i][i] = 1;
            DP[i][1] = i;
        }
        for(int i=2; i<30; i++){
            for(int j= i+1; j<30; j++){
                DP[j][i] = DP[j-1][i] + DP[j-1][i-1];
            }
        }
        for(int i = 0; i<N; i++){
            int W = scan.nextInt();
            int E = scan.nextInt();
            System.out.println(DP[E][W]);
        }
    }
}
