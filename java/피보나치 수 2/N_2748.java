import java.util.Scanner;

public class N_2748 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long DP[] = new long[N+1];
        DP[0] = 0;
        DP[1] = 1;
        for (int i=2; i<=N; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }
        System.out.println(DP[N]);
    }
}
