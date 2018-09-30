import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Line_2018_02 {
    static int[][] next = {{0,1,2,3},{1, 3,0,2}, {2,0,3,1}, {3,2,1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        LinkedList<Node>[] map = new LinkedList[n];
        VectorInfo[][] vectorInfos = new VectorInfo[n][n];
        boolean[][] b = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            map[i] = new LinkedList<Node>();
            for(int j=0; j<n; j++){
                vectorInfos[i][j] = new VectorInfo();
                map[i].offer(new Node(str[j].charAt(0), str[j].charAt(1)));
            }
        }
        Map<Character, Integer> mp = new HashMap<Character, Integer>();

        mp.put('F', 0);
        mp.put('R', 1);
        mp.put('L', 2);
        mp.put('B', 3);
        int preInfo = 3;
        int current_x = 0;
        int current_y = 0;
        vectorInfos[0][0].list.offer(0);
        b[0][0] = true;
        while(true){
            Node currentNode = map[current_y].get(current_x);
            int currentInfo = mp.get(currentNode.info);
            int nextInfo = next[preInfo][currentInfo];
            int dist = currentNode.weight;

            //boolean isVisit = b[current_x][current_y];
            boolean exit = false;
            for(int vector : vectorInfos[current_x][current_y].list){
                if (vector == nextInfo){
                    exit = true;
                    break;
                }
            }
            if (exit){
                System.out.print(current_x+" "+current_y);
                break;
            }
            vectorInfos[current_x][current_y].list.offer(nextInfo);
            if (nextInfo == 0){
                current_y -= dist;
            } else if(nextInfo == 1){
                current_x += dist;
            } else if(nextInfo == 2){
                current_x -= dist;
            } else if(nextInfo == 3){
                current_y += dist;
            }
            b[current_x][current_y] = true;
            preInfo = nextInfo;
        }
    }
}

class Node {
    public char info;
    public int weight;
    public Node(char info, int weight){
        this.info = info;
        this.weight = weight-48;
    }

}
class VectorInfo {
    public LinkedList<Integer> list;
    public VectorInfo() {
        this.list = new LinkedList<Integer>();
    }
}
