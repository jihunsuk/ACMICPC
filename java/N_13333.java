import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_13333 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        str = reader.readLine();
        String arr[] = str.split(" ");
        int nonmun[] = new int[n+1];
        for(int i=1; i<=n; i++)
            nonmun[i] = Integer.parseInt(arr[i-1]);

        Arrays.sort(nonmun);
        int K = 0;
        for (int k=0; k<=n; k++){
            for (int i=1; i<=n; i++){
                if(nonmun[i] >= k)
                    if (n-i+1 == k)
                        K = k;
            }
        }
        System.out.println(K);
    }
}
