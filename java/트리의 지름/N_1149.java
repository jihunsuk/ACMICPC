import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int N = Integer.parseInt(str);
        int map[][] = new int[N+1][N];
        for(int i=1; i<=N; i++){
            str = reader.readLine();
            String strArr[] = str.split(" ");
            for(int j=0; j<3; j++)
                map[i][j] = Integer.parseInt(strArr[j]);
        }
        int DP[][] = new int[N+1][3];
        for(int i=1; i<=N; i++){
            DP[i][0] = DP[i-1][1] + map[i][0];
            DP[i][0] = Math.min(DP[i][0], DP[i-1][2] + map[i][0]);
            DP[i][1] = DP[i-1][2]  + map[i][1];
            DP[i][1] = Math.min(DP[i][1], DP[i-1][0] + map[i][1]);
            DP[i][2] = DP[i-1][0] + map[i][2];
            DP[i][2] = Math.min(DP[i][2], DP[i-1][1] + map[i][2]);
        }
        System.out.println(Math.min(Math.min(DP[N][0], DP[N][1]), DP[N][2]));
    }
}
