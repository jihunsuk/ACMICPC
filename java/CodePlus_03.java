import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CodePlus_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        if(h<2 || h>50 || w<2 || w>50){
            System.out.println(-1);
        } else{
            int[][] map = new int[h][w];
            boolean[][] b = new boolean[h][w];
            for(int i=0 ;i<h; i++)
                for(int j=0; j<w; j++)
                    map[i][j] = -1;
            map[0][0] = 0;
            bfs(map, b);
        }
    }


    public static void bfs(int[][] map, boolean[][] b){
        int max_X = map[0].length-1;
        int max_Y = map.length-1;
        Queue<pos> q = new LinkedList<pos>();
        q.add(new pos(0,0, 0));
        b[0][0] = true;
        while(!q.isEmpty()){
            boolean move = false;
            pos current = q.remove();
            if (current.x+2 <= max_X && current.y+1 <= max_Y && !b[current.y+1][current.x+2]){
                q.add(new pos(current.y+1, current.x+2, current.dist+1));
                b[current.y+1][current.x+2] = true;
                move = true;
            }
            if (current.x+2 <= max_X && current.y-1 >= 0 && !b[current.y-1][current.x+2]){
                q.add(new pos(current.y-1, current.x+2, current.dist+1));
                b[current.y-1][current.x+2] = true;
                move = true;
            }
            if (current.x-2 >= 0 && current.y+1 <= max_Y && !b[current.y+1][current.x-2]){
                q.add(new pos(current.y+1, current.x-2, current.dist+1));
                b[current.y+1][current.x-2] = true;
                move = true;
            }
            if (current.x-2 >= 0 && current.y-1 >= 0 && !b[current.y-1][current.x-2]){
                q.add(new pos(current.y-1, current.x-2, current.dist+1));
                b[current.y-1][current.x-2] = true;
                move = true;
            }

            if (current.x+1 <= max_X && current.y+2 <= max_Y && !b[current.y+2][current.x+1]){
                q.add(new pos(current.y+2, current.x+1, current.dist+1));
                b[current.y+2][current.x+1] = true;
                move = true;
            }
            if (current.x+1 <= max_X && current.y-2 >= 0 && !b[current.y-2][current.x+1]){
                q.add(new pos(current.y-2, current.x+1, current.dist+1));
                b[current.y-2][current.x+1] = true;
                move = true;
            }
            if (current.x-1 >= 0 && current.y+2 <= max_Y && !b[current.y+2][current.x-1]){
                q.add(new pos(current.y+2, current.x-1, current.dist+1));
                b[current.y+2][current.x-1] = true;
                move = true;
            }
            if (current.x-1 >= 0 && current.y-2 >= 0 && !b[current.y-2][current.x-1]){
                q.add(new pos(current.y-2, current.x-1, current.dist+1));
                b[current.y-2][current.x-1] = true;
                move = true;
            }

            if(move == false && q.size() == 0){
                boolean f = false;
                for(int i=0; i<=max_Y; i++){
                    for(int j=0; j<max_X; j++){
                        if(b[i][j] == false){
                            f = true;
                            break;
                        }
                    }
                }
                if(f)
                    System.out.println("F"+current.dist);
                else
                    System.out.println("T"+current.dist);
            }

        }

    }
}

class pos {
    int x;
    int y;
    int dist;
    public pos(int y, int x, int dist){
        this.x= x;
        this.y= y;
        this.dist = dist;
    }
}