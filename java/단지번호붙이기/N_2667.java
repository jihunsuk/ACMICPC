import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N_2667 {
    static int[][] map;
    static boolean[][] found;
    static ArrayList<Integer> list = new ArrayList();
    static int c;
    static int n;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        map = new int[n+2][n+2];
        found = new boolean[n+2][n+2];
        scan.nextLine();
        for(int i=1; i<=n; i++){
            String N = scan.nextLine();
            for(int j=1; j<=n; j++){
                map[i][j] = N.charAt(j-1)-48;
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] == 1 && !found[i][j]){
                    c = 0;
                    dfs(i, j);
                    list.add(c);
                }
            }
        }
        Integer[] a = list.toArray(new Integer[list.size()]);
        Arrays.sort(a);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++)
            System.out.println(a[i]);
    }
    static void dfs(int h, int w){
        found[h][w] = true;
        c++;
        if(h+1<=n &&!found[h+1][w] && map[h+1][w] == 1)
            dfs(h+1, w);
        if(h-1>=1 && !found[h-1][w] && map[h-1][w] == 1)
            dfs(h-1, w);
        if(w+1<=n && !found[h][w+1] && map[h][w+1] == 1)
            dfs(h, w+1);
        if(w-1>=1 && !found[h][w-1] && map[h][w-1] == 1)
            dfs(h, w-1);
    }
}
