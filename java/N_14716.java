import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_14716 {
    static boolean b[][];
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String strArr[] = str.split(" ");
        int H = Integer.parseInt(strArr[0]);
        int W = Integer.parseInt(strArr[1]);
        b = new boolean[H+2][W+2];
        map = new int[H+2][W+2];

        for(int i=1; i<=H; i++){
            str = reader.readLine();
            strArr = str.split(" ");
            for(int j=1; j<=strArr.length; j++)
                map[i][j] = Integer.parseInt(strArr[j-1]);
        }

        int Count = 0;
        for(int i=1; i<=H; i++){
            for(int j=1; j<=W; j++){
                if(b[i][j] == false && map[i][j] == 1){
                    solve(i, j);
                    Count++;
                }
            }
        }
        System.out.println(Count);
    }
    public static void solve(int H, int W){
        b[H][W] = true;
        if(map[H+1][W] == 1 && b[H+1][W] == false)
            solve(H+1, W);
        if(map[H][W+1] == 1 && b[H][W+1] == false)
            solve(H, W+1);
        if(map[H-1][W] == 1 && b[H-1][W] == false)
            solve(H-1, W);
        if(map[H][W-1] == 1 && b[H][W-1] == false)
            solve(H, W-1);
        if(map[H-1][W-1] == 1 && b[H-1][W-1] == false)
            solve(H-1, W-1);
        if(map[H+1][W+1] == 1 && b[H+1][W+1] == false)
            solve(H+1, W+1);
        if(map[H+1][W-1] == 1 && b[H+1][W-1] == false)
            solve(H+1, W-1);
        if(map[H-1][W+1] == 1 && b[H-1][W+1] == false)
            solve(H-1, W+1);
    }
}
