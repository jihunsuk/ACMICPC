import java.util.Scanner;

public class N_14924 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int S1 = scan.nextInt();
        int S2 = scan.nextInt();
        int D = scan.nextInt();

        int T = D/(S1*2);
        System.out.println(S2*T);
    }
}
