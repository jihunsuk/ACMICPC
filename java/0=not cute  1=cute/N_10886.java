import java.util.Scanner;

public class N_10886 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int odd = 0;
        int even = 0;
        for(int i=0; i<N; i++){
            int a = scan.nextInt();
            if ( a == 0)
                even++;
            else
                odd++;
        }
        if (even > odd )
            System.out.println("Junhee is not cute!");
        else
            System.out.println("Junhee is cute!");
    }
}
