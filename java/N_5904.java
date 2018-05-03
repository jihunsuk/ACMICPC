import java.util.Scanner;

/**
 * Created by tjrwl on 2018-01-18.
 */
public class N_5904 {
    static int S[] = new int[30];
    static char c;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        S[0] = 3;
        int i;
        for(i=0; S[i] < N; i++){
            S[i+1] = 2*S[i]+i+4;
        }
        ans(i, N);
        System.out.println(c);
    }
    static void ans(int i, int N){
        if ( i == 0){
            if ( N == 1)
                c = 'm';
            else
                c = 'o';
            return;
        }
        if ( N <= S[i-1])
            ans(i-1, N);
        else if ( N > S[i-1] && N < S[i-1]+i+3){
            if ( N == S[i-1] + 1) c = 'm';
            else c = 'o';
            return;
        } else {
            ans(i - 1, N - S[i - 1] - i - 3);
            return;
        }
    }
}

