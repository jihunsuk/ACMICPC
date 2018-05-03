import java.util.Scanner;

public class N_11052 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] DP = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1; i<=N; i++){
            P[i] = scan.nextInt();
        }
        DP[0] = 0;
        DP[1] = P[1];
        DP[2] = Math.max(P[1]*2, P[2]);

        for(int i=3; i<=N; i++){
            for(int j=1; j<=i;j++)
                DP[i] = Math.max(DP[i-j]+P[j], DP[i]);
        }
        System.out.println(DP[N]);
    }
}