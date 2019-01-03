import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 너무 더럽게 힘들게 짰따. 리팩토링이 필요하다.
// 다음에는 물부터 bfs한 후 고슴도치를 bfs해보자.
public class N_3055 {
    static int[] toY = {1, 0, -1, 0};
    static int[] toX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        final int R = Integer.parseInt(input[0]);
        final int C = Integer.parseInt(input[1]);
        final char[][] map = new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = reader.readLine().toCharArray();
        }

        bfs(map);
    }
    static void bfs(char[][] map){
        int S_Y = -1;
        int S_X = -1;
        boolean isStar = false;

        //물위치 저장, 고슴도치 위치 기억, 별이 있는지 없는지 판단
        LinkedList<pos> originWaterPos = new LinkedList<pos>();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if (map[i][j] == '*'){
                    originWaterPos.offer(new pos(i, j, 0));
                    isStar = true;
                } else if(map[i][j] == 'S'){
                    S_Y = i;
                    S_X = j;
                }
            }
        }

        //초기화
        int[][] fillWaterTime = new int[map.length][map[0].length];
        for(int i=0; i<map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'X' || map[i][j] == 'D')
                    fillWaterTime[i][j] = -2;
                else
                    fillWaterTime[i][j] = -1;
            }
        }

        //물이 퍼져나가는것을 생각해 해당위치에 물이 차는 시간을 기록
        for(pos curPos : originWaterPos){
            boolean[][] visited2 = new boolean[map.length][map[0].length];
            Queue<pos> q = new LinkedList<pos>();
            q.add(curPos);
            fillWaterTime[curPos.y][curPos.x] = 0;
            visited2[curPos.y][curPos.x] = true;
            while(!q.isEmpty()){
                pos current = q.poll();
                for(int i=0; i<toY.length; i++){
                    int nextY = current.y + toY[i];
                    int nextX = current.x + toX[i];

                    if (nextY >= 0 && nextY < fillWaterTime.length
                            && nextX >= 0 && nextX < fillWaterTime[0].length){
                        if (map[nextY][nextX] == '.' && !visited2[nextY][nextX]) { //.이고 아직 안간곳이다.
                           if (fillWaterTime[nextY][nextX] != -1){ //근데 이미 물이 찼다
                                    if(fillWaterTime[nextY][nextX] > current.time + 1) { // 내가 더 빨리 도달한다.
                                        fillWaterTime[nextY][nextX] = current.time + 1;
                                        q.add(new pos(nextY, nextX, current.time + 1));
                                        visited2[nextY][nextX] = true;
                                    } else{ // 내가 더 늦게 도달하므로 아무것도 안한다.
                                        continue;
                                    }
                            } else {    // 내가 처음으로 왔다.
                               q.add(new pos(nextY, nextX, current.time + 1));
                               fillWaterTime[nextY][nextX] = current.time + 1;
                               visited2[nextY][nextX] = true;
                           }
                        }
                    }
                }
            }
        }

        //고슴도치를 이동한다.
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<pos> q = new LinkedList<pos>();
        q.add(new pos(S_Y, S_X, 0));
        visited[S_Y][S_X] = true;
        while(!q.isEmpty()) {
            pos cur_S_pos = q.poll();

            for(int i=0; i<toY.length; i++){
                int nextY = cur_S_pos.y + toY[i];
                int nextX = cur_S_pos.x + toX[i];

                if (nextY >= 0 && nextY < fillWaterTime.length
                        && nextX >= 0 && nextX < fillWaterTime[0].length){
                    if (map[nextY][nextX] == 'D') { //동굴 도착이면 끝낸다.
                        System.out.println(cur_S_pos.time+1);
                        return;
                    }
                    if (isStar){    //벽이 있는 구조이다.
                        if (fillWaterTime[nextY][nextX] != -2 &&    //벽이 없고
                                cur_S_pos.time + 1 < fillWaterTime[nextY][nextX] && //가는곳이 아직 물이 안찼다.
                                map[nextY][nextX] == '.' && !visited[nextY][nextX]) { //.이고 아직 안간곳이다.
                            q.add(new pos(nextY, nextX, cur_S_pos.time + 1));
                            visited[nextY][nextX] = true;
                        } else if (fillWaterTime[nextY][nextX] == -1 && //
                                map[nextY][nextX] == '.' && !visited[nextY][nextX]){
                            q.add(new pos(nextY, nextX, cur_S_pos.time + 1));
                            visited[nextY][nextX] = true;
                        }
                    } else {    //벽이 없는 구조이다. 따라서 그냥 이동하면 된다.
                        if (fillWaterTime[nextY][nextX] != -2 &&
                                map[nextY][nextX] == '.' && !visited[nextY][nextX]){
                            q.add(new pos(nextY, nextX, cur_S_pos.time + 1));
                            visited[nextY][nextX] = true;
                        }
                    }
                }
            }
        }
        System.out.print("KAKTUS");
    }

    static private class pos {
        public int y;
        public int x;
        public int time;
        public pos(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
