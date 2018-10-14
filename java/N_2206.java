import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//현재 좌표에 도달했을 때, 벽을 부수고 온경우와 벽을 부수지 않고 온 경우가 있기 때문에
//2개의 visited를 사용해 각각의 경우를 다 Queue에 넣을 수 있도록 한다.
//아래의 경우가 그렇다
//8 8
//01000100
//01010100
//01010100
//01010100
//01010100
//01010100
//01010100
//00010100

public class N_2206 {
    static int x, y;
    static char[][] map;
    static boolean[][] visited1, visited2;
    static int[] toY = {0, 1, 0, -1};
    static int[] toX = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = reader.readLine().split(" ");
        y = Integer.parseInt(input[0]);
        x = Integer.parseInt(input[1]);
        map = new char[y][x];
        visited1 = new boolean[y][x];
        visited2 = new boolean[y][x];
        for(int i=0; i<y; i++){
            map[i] = reader.readLine().toCharArray();
        }

        bfs();
    }
    static void bfs() {
        Queue<pos> q = new LinkedList<pos>();
        q.add(new pos(0,0,1, false));
        visited1[0][0] = true;
        visited2[0][0] = true;
        while(!q.isEmpty()){
            pos curPos = q.poll();

            if(curPos.y+1 == y && curPos.x+1 == x){
                System.out.println(curPos.dist);
                return;
            }

            for(int i=0; i<toX.length; i++){
                int nextX = curPos.x + toX[i];
                int nextY = curPos.y + toY[i];
                if(nextX >= 0 && nextX < x && nextY >= 0 && nextY < y){
                    if(!curPos.wallBreak && map[nextY][nextX] == '0' && !visited1[nextY][nextX]){  //안부수고 왔고 다음좌표 0인경우
                        q.add(new pos(nextY, nextX,curPos.dist+1 , curPos.wallBreak));
                        visited1[nextY][nextX] = true;
                    } else if(!curPos.wallBreak && map[nextY][nextX] == '1' && !visited2[nextY][nextX]){ //안부수고 왔고 다음좌표 1인경우
                        q.add(new pos(nextY, nextX, curPos.dist+1, true));
                        visited2[nextY][nextX] = true;
                    } else if(curPos.wallBreak && map[nextY][nextX] == '0' && !visited2[nextY][nextX]) { //부수고 왔고 다음좌표 0인경우
                        q.add(new pos(nextY, nextX, curPos.dist+1, curPos.wallBreak));
                        visited2[nextY][nextX] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static private class pos {
        public int y;
        public int x;
        public int dist;
        public boolean wallBreak = false;

        public pos(int y, int x, int dist, boolean wallBreak){
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.wallBreak = wallBreak;
        }
//        public pos(int y, int x, int dist, boolean useWallBreaker, int breakY, int breakX){
//            this.y = y;
//            this.x = x;
//            this.dist = dist;
//            this.useWallBreaker = useWallBreaker;
//            this.breakY = breakY;
//            this.breakX = breakX;
//        }
    }
}
