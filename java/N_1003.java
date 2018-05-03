import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int T = Integer.parseInt(str);
        for(int i=0; i<T; i++){
            str = reader.readLine();
            int N = Integer.parseInt(str);
            fibonacchi(N);
            System.out.println(fibonacchi(N) + " " + fibonacchi(N+1));
        }
    }

    static int fibonacchi(int N){
        if( N == 0){
            return 1;
        } else if ( N == 1){
            return 0;
        } else{
            int a=1;
            int b=0;
            int c=1;

            for(int i=0; i<N-2; i++){
                a=b;
                b=c;
                c=a+b;
            }
            return c;


        }
    }
}
