import java.util.Scanner;

public class N_10409 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int T = scan.nextInt();
        int D[] = new int[N];
        for(int i=0; i<N; i++){
            D[i] = scan.nextInt();
        }
        int sum = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            sum += D[i];
            if (sum <= T)
                count++;
        }
        System.out.println(count);
    }
}
