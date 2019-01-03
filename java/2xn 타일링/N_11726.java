import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        int DP[] = new int[1001];
        DP[1] = 1;
        DP[2] = 2;
        for (int i=3; i<=n; i++){
            DP[i] = (DP[i-1] + DP[i-2])%10007;
        }
        System.out.println(DP[n]);
    }
}
