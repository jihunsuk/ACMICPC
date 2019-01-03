import java.util.Scanner;

/**
 * Created by tjrwl on 2017-10-13.
 */
public class N_2573 {
    static int H, W;
    static int[][] map;
    static boolean[][] map_arrive;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        H = scan.nextInt();
        W = scan.nextInt();
        map = new int[H+1][W+1];
        map_arrive = new boolean[H+1][W+1];
        for(int i=1; i<=H; i++){
            for(int j=1; j<=W; j++){
                map[i][j] = scan.nextInt();
            }
        }

        int year = 0;
        while(true){
            boolean found = false;
            for(int i=1; i<=H; i++){
                for(int j=1; j<=W; j++){
                    if(map[i][j] != 0)
                        found = true;
                }
            }
            if(found){
                if(count_map() >= 2){
                    System.out.println(year);
                    break;
                }

                else {
                    year++;
                    map_arrive = new boolean[H+1][W+1];
                    map = down_map();
                }
            } else{
                System.out.println(0);
                break;
            }
        }

    }

    static int count_map(){
        int count = 0;
        for(int i=1; i<=H; i++){
            for(int j=1; j<=W; j++){
                if(map[i][j] != 0 && !map_arrive[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int H, int W){
        map_arrive[H][W] = true;
        if(map[H+1][W] != 0 && !map_arrive[H+1][W])
            dfs(H+1, W);
        if(map[H][W+1] != 0 && !map_arrive[H][W+1])
            dfs(H, W+1);
        if(map[H-1][W] != 0 && !map_arrive[H-1][W])
            dfs(H-1, W);
        if(map[H][W-1] != 0 && !map_arrive[H][W-1])
            dfs(H, W-1);
    }

    static int[][] down_map(){
        int[][] new_map = new int[H+1][W+1];
        for(int i=1; i<=H; i++){
            for(int j=1; j<=W; j++){

                if(map[i][j] != 0){
                    int zero_N = 0;
                    if(map[i+1][j] == 0)
                        zero_N++;
                    if(map[i][j+1] == 0)
                        zero_N++;
                    if(map[i-1][j] == 0)
                        zero_N++;
                    if(map[i][j-1] == 0)
                        zero_N++;
                    new_map[i][j] = map[i][j]-zero_N;
                }
                if(new_map[i][j] < 0)
                    new_map[i][j] = 0;
            }
        }
        return new_map;
    }
}
