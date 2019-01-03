import java.util.Scanner;

/**
 * Created by tjrwl on 2018-01-07.
 */
public class N_1929{
    static boolean prime[];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        prime = new boolean[B+1];
        prime[1] = true;
        for(int i=2;i<=B;i++) {
            if (prime[i] == true) continue;
            for (int j = i * 2; j <= B; j += i) {
                prime[j] = true;
            }
        }
        for(int i=A; i<=B; i++)
            if (prime[i] == false)
                System.out.println(i);
    }
}
