import java.util.Scanner;

public class N_2146 {

    static int map[][];
    static int N;
    static boolean found[][];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N+2][N+2];
        found = new boolean[N+2][N+2];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = scan.nextInt();
            }
        }
        int Count = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(found[i][j] == false && map[i][j] != 0){
                    search(i, j, Count);
                    Count++;
                }
            }
        }

        bridge();
    }
    static void search(int H, int W, int Count){
        found[H][W] = true;
        map[H][W] = Count;
        if (found[H-1][W] == false && map[H-1][W] != 0)
            search(H-1, W, Count);
        if (found[H+1][W] == false && map[H+1][W] != 0)
            search(H+1, W, Count);
        if (found[H][W-1] == false && map[H][W-1] != 0)
            search(H, W-1, Count);
        if (found[H][W+1] == false && map[H][W+1] != 0)
            search(H, W+1, Count);
    }

    static void bridge(){
        int min = 10000;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=i; k<=N; k++){
                    for(int n=j; n<=N; n++){
                        if (map[i][j] != 0 && map[k][n] != 0 && map[i][j] != map[k][n]){
                            int a = 0;
                            if(i == k)
                                a = Math.abs(n-j-1);
                            else if( j == n){
                                a = Math.abs(k-i-1);
                            } else{
                                a = Math.abs(n-j-1+k-i);
                            }
                            if(min > a)
                                min = a;
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}