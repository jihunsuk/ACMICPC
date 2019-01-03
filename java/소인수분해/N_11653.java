import java.util.Scanner;

public class N_11653 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        boolean prime[] = new boolean[N+1];
        prime[1] = true;
        for(int i=2;i<=N;i++) {
            if (prime[i] == true) continue;
            for (int j = i * 2; j <= N; j += i) {
                prime[j] = true;
            }
        }
        while(N != 1){
            for(int i=2; i<=N; i++){
                if ( !prime[i] && (N % i == 0)){
                    N /= i;
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
