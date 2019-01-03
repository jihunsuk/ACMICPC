import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UCPC2018_B_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        long card[] = new long[N];
        str = reader.readLine().split(" ");
        for(int i=0; i<N; i++){
            card[i] = Long.parseLong(str[i]);
        }
        for(int i=0; i<M; i++){
            Arrays.sort(card);
            long sum = card[0] + card[1];
            card[0] = sum;
            card[1] = sum;
        }
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += card[i];
        }
        System.out.println(sum);
    }
}
