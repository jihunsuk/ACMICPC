import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// casting을 최소한으로 하는게 좋다는것을 배움

public class N_1525 {
    private static Set<String> puzzle = new HashSet<String>();
    private static int[] to = {-1, 1, -3, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String p = "";
        for(int i=0; i<3; i++){
            String[] input = reader.readLine().split(" ");
            p  += input[0];
            p  += input[1];
            p  += input[2];
        }

        int ans = solve(p);
        System.out.println(ans);
    }
    public static int solve(String start) {

        Queue<Puzzle> q = new LinkedList<Puzzle>();
        q.add(new Puzzle(start, 0));
        puzzle.add(start);

        while(!q.isEmpty()){
            Puzzle current = q.poll();
            if (String.valueOf(current.puzzle).equals("123456780")){
                return current.moving;
            }
            int index = -1;
            String now = current.puzzle;

            for(int i=0; i<now.length(); i++) {
                if (now.charAt(i) == '0') {
                    index = i;
                    break;
                }
            }

            for(int i=0; i<to.length; i++){
                int nextIndex = index+to[i];
                if(i == 0 || i == 1){
                    if (nextIndex / 3 != index / 3)
                        continue;
                }
                if(nextIndex >=0 && nextIndex < 9){
                    StringBuilder next = new StringBuilder(now);
                    char tmp = next.charAt(nextIndex);
                    next.setCharAt(nextIndex, next.charAt(index));
                    next.setCharAt(index,tmp);
                    String t = next.toString();
                    if (!puzzle.contains(t)){
                        q.add(new Puzzle(t, current.moving+1));
                        puzzle.add(t);
                    }
                }
            }
        }
        return -1;
    }
}

class Puzzle {
    public String puzzle;
    public int moving;
    public Puzzle(String p, int m){
        this.puzzle = p;
        this.moving = m;
    }
}
