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
        int[][] DP = new int[N+1][2];
        int[] P = new int[N+1];
        for(int i=1; i<=N; i++){
            P[i] = Integer.parseInt(strArr2[i-1]);
        }

        DP[0][0] = S;
        DP[0][1] = S;

        boolean sucess = true;
        for(int i=1; i<=N; i++){
            int max = -1;
            if (DP[i-1][1] != -1 && DP[i-1][1] + P[i] <= M)
                max = DP[i-1][1] + P[i];
            if (DP[i-1][0] != -1 && DP[i - 1][0] + P[i] <= M) {
                max = Math.max(max, DP[i - 1][0] + P[i]);
            }
            DP[i][1] = max;
            max = -1;
            if (DP[i-1][1] != -1 && DP[i-1][1] - P[i] >= 0)
                max = DP[i-1][1] - P[i];
            if (DP[i-1][0] != -1 && DP[i - 1][0] - P[i] >= 0) {
                max = Math.max(max, DP[i - 1][0] - P[i]);
            }
            DP[i][0] = max;
            if(DP[i][0] == -1 && DP[i][1] == -1){
                sucess = false;
                break;
            }
        }
        if (!sucess)
            System.out.println(-1);
        else
            System.out.println(Math.max(DP[N][0], DP[N][1]));
    }
}
