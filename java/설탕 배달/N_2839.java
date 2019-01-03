import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int N = Integer.parseInt(str);
        System.out.println(solve(N));
    }
    public static int solve(int N){
        int N_3 = N/3;
        int N_5 = N/5;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=N_5; i++){
            for(int j=0; j<=N_3; j++){
                if(3*j + 5*i == N){
                    if(min > i+j)
                        min = j+i;
                }
            }
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
