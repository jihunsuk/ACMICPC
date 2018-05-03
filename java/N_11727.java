import java.util.Scanner;

public class N_11727 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long DP[] = new long[1001];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 3;
        for(int i=3; i<=N; i++){
            DP[i] = (DP[i-1] + DP[i-2]*2)%10007;
        }
        System.out.println(DP[N]);
    }
}
