import java.util.Scanner;

public class N_1934 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N =scan.nextInt();
        for(int i=0; i<N; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();
            System.out.println(lcm(A, B));
        }
    }

    public static int gcd(int a, int b) {
        while(b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
