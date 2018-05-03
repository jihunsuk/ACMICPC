import java.util.Scanner;


/* 시간초과라고 뜸 ㅜㅠ */
public class N_11657 {
    static int N;
    static int Edge[][];
    static int M[][];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N =  scan.nextInt();
        Edge = new int[N+1][N+1];
        M = new int[N+1][N+1];
        Dis = new int[N];
        int E = scan.nextInt();
        for(int i=0; i<E; i++){
            int H = scan.nextInt();
            int W = scan.nextInt();
            Edge[H-1][W-1] = scan.nextInt();
        }
        boolean t = false;
        for(int i=1; i<N; i++){
            search(i);
            if (C == 1) {
                System.out.println(-1);
                t = true;
                break;
            }
        }
        if (t == false){
            for(int i=1; i<N; i++){
                if (Dis[i] == 10000000){
                    System.out.println("-1");
                } else
                    System.out.println(Dis[i]);
            }
        }
    }
    static int C;
    static int Dis[];
    static void search(int a){
        for(int i=0; i<N; i++)
            M[0][i] = 10000000;	//최대값이라 가정  Infinity로하는경우 +1만되도 음수가되버림
        M[0][a] = 0;

        //i개의 Edge를 사용해 j부터 endVertex까지 갈수있는 최단거리를 구한다.
        for(int i=1; i<N; i++) {
            for (int j = 0; j < N; j++) {
                M[i][j] = M[i - 1][j];
                for (int k = 0; k < N; k++) {
                    if (Edge[j][k] != 0) {
                        M[i][j] = Math.min(M[i][j], M[i - 1][k] + Edge[j][k]);
                    }
                }
            }
        }
        Dis[a] = M[N-1][0];
       if (Dis[a] <= 0)
           C = 1;
    }
}
