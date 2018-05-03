import java.util.Scanner;

public class N_1074 {
    static int Count = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();
        ans(N, r+1, c+1);
        System.out.println(Count);
    }
    static void ans(int N, int r, int c){
        if (r <= 2 && c <= 2){
            if ( r == 1)
                Count += c-1;
            else
                Count += c+1;
        } else{
            int h = (int)Math.pow(2, N)/2;
            if ( r <= h && c <= h){ //왼쪽상단
                ans(N-1, r, c);
            } else if ( r <= h && c > h){   //오른쪽상단
                Count += h*h;
                ans(N-1, r, c-h);
            } else if ( r > h && c <= h){   //왼쪽하단
                Count += h*h*2;
                ans(N-1, r-h, c);
            } else {    //오른쪽하단
                Count += h*h*3;
                ans(N-1, r-h, c-h);
            }
        }
    }
}
