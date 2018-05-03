import java.util.Scanner;

/**
 * Created by tjrwl on 2017-12-13.
 */
public class N_11053 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];
        int[] DP = new int[N];
        for(int i=0; i<N; i++)
            A[i] = scan.nextInt();
        int maxLength = 0;
        for(int i=0; i<N; i++){
            DP[i] = 1;
            for(int k=i-1; k>=0; k--){
                if(A[k] < A[i]){
                    DP[i] = Math.max(DP[i], DP[k]+1);
                }
            }
            if (maxLength < DP[i])
                maxLength = DP[i];
        }
            System.out.println(maxLength);
    }
}
