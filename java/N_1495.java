import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] strArr = str.split(" ");
        String str2 = reader.readLine();
        String[] strArr2 = str2.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int S = Integer.parseInt(strArr[1]);
        int M = Integer.parseInt(strArr[2]);
        int[][] DP = new int[N+1][1001];
        int[] P = new int[N+1];
        for(int i=1; i<=N; i++){
            P[i] = Integer.parseInt(strArr2[i-1]);
        }

        DP[0][S] = 1;
        for(int i=1; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(DP[i-1][j] == 0)
                    continue;
                if (j+P[i] <=M)
                    DP[i][j+P[i]] = 1;
                if (j-P[i] >= 0)
                    DP[i][j-P[i]] = 1;
            }
        }
        System.out.println(ans(DP, M, N));
    }
    static int ans(int[][] DP,int M, int N){
        for(int i=M; i>=0; i--)
            if(DP[N][i] == 1)
                return i;
        return -1;
    }
}
