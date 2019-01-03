import java.util.Scanner;

public class N_2622 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int C = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i; j < N; j++) {
                int k = N - (i + j);
                if (k < j)
                    break;
                if (i + j > k)
                    C++;
            }
        }
        System.out.println(C);
    }
}