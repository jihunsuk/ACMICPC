import java.util.Scanner;

public class N_2490 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        for(int i=0; i<3; i++){
                int a = scan.nextInt();
                int b = scan.nextInt();
                int c = scan.nextInt();
                int d = scan.nextInt();
                game(a,b,c,d);
        }

    }
    static void game(int a, int b, int c, int d){
        int C = 0;
        if (a == 0)
            C++;
        if (b == 0)
            C++;
        if (c == 0)
            C++;
        if (d == 0)
            C++;
        if (C == 0)
            System.out.println('E');
        else if (C == 1){
            System.out.println('A');
        }
        else if (C == 2){
            System.out.println('B');
        }
        else if (C == 3){
            System.out.println('C');
        } else{
            System.out.println('D');
        }
    }
}
