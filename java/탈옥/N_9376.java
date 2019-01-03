import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 참고 http://stack07142.tistory.com/145   너무 어렵다....
public class N_9376 {
    static  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] toX = {1, 0, -1, 0};
    static int[] toY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++) {
            String[] input = reader.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);

            pos person1 = new pos(0, 0);
            pos person2 = new pos(0, 0);
            pos person3 = new pos(0, 0);
            boolean find = false;
            char[][] map = new char[h+2][w+2];
            for(int j=0; j<map[0].length; j++){
                map[0][j] = '.';
                map[h+1][j] = '.';
            }
            for(int j=1; j<=h; j++){
                String s = "." + reader.readLine() + ".";
                for(int k=0; k<map[0].length; k++){
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == '$'){
                        if (!find){
                            person2.x = k;
                            person2.y = j;
                            find = true;
                        } else{
                            person3.x = k;
                            person3.y = j;
                        }

                    }
                }
            }

            int[][] doorNumber1 = new int[map.length][map[0].length];
            int[][] doorNumber2 = new int[map.length][map[0].length];
            int[][] doorNumber3 = new int[map.length][map[0].length];

            for(int j=0; j<map.length; j++)
                for(int k=0; k<map[0].length; k++){
                    doorNumber1[j][k] = -1;
                    doorNumber2[j][k] = -1;
                    doorNumber3[j][k] = -1;
                }

            bfs(map, doorNumber1, person1);
            bfs(map, doorNumber2, person2);
            bfs(map, doorNumber3, person3);

            int ans = Integer.MAX_VALUE;
            for(int j=0; j<map.length; j++) {
                for (int k = 0; k < map[0].length; k++) {
                    if (map[j][k] != '*'){
                        if(map[j][k] == '#'){
                            ans = Math.min(ans, doorNumber1[j][k] + doorNumber2[j][k] + doorNumber3[j][k] - 2);
                        } else{
                            ans = Math.min(ans, doorNumber1[j][k] + doorNumber2[j][k] + doorNumber3[j][k]);
                        }
                    }
                }
            }
            System.out.println(ans);
        }

    }
    static void bfs(char[][] map, int[][] doorNumber, pos person){

        Queue<pos> q = new LinkedList<pos>();
        q.add(person);
        doorNumber[person.y][person.x] = 0;
        while(!q.isEmpty()){
            pos curPos = q.poll();

            for(int i=0; i<toX.length; i++){
                int nextY = curPos.y + toY[i];
                int nextX = curPos.x + toX[i];
                if(nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length) continue;
                if (map[nextY][nextX] == '*') continue;

                if (map[nextY][nextX] == '#'){
                    if (doorNumber[nextY][nextX] == -1 || doorNumber[nextY][nextX] > doorNumber[curPos.y][curPos.x]+1) {
                        doorNumber[nextY][nextX] = doorNumber[curPos.y][curPos.x] + 1;
                        q.add(new pos(nextY, nextX));
                    }
                } else {
                    if (doorNumber[nextY][nextX] == -1 || doorNumber[nextY][nextX] > doorNumber[curPos.y][curPos.x]) {
                        doorNumber[nextY][nextX] = doorNumber[curPos.y][curPos.x];
                        q.add(new pos(nextY, nextX));
                    }
                }
            }
        }
    }

    static private class pos {
        public int y;
        public int x;
        public pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
