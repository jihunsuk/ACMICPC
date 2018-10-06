import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int S = Integer.parseInt(reader.readLine());

        boolean[][] visited = new boolean[1001][1001];

        Queue<Screen> q = new LinkedList<Screen>();
        q.add(new Screen(1, 0, 0));
        visited[1][0] = true;
        while(!q.isEmpty()) {
            Screen current = q.poll();
            if (current.number == S){
                System.out.println(current.time);
                break;
            }
            // 클립보드 저장
            if (!visited[current.number][current.number]){
                Screen next = new Screen(current.number, current.number, current.time+1);
                q.add(next);
                visited[current.number][current.number] = true;
            }
            //클립보드 복사

            //화면 붙여넣기
            int addNumber = current.number + current.clipboard;
            if(addNumber <= 1000 && !visited[addNumber][current.clipboard] && current.clipboard != 0) {
                Screen next = new Screen(addNumber, current.clipboard, current.time + 1);
                q.add(next);
                visited[addNumber][current.clipboard] = true;
            }

            //화면에서 한개 삭제
            int minusNumber = current.number-1;
            if(!visited[minusNumber][current.clipboard] && current.number != 1) {
                Screen next = new Screen(minusNumber, current.clipboard, current.time + 1);
                q.add(next);
                visited[minusNumber][current.clipboard] = true;
            }
        }
    }
}

class Screen {
    public int number;
    public int clipboard;
    public int time;
    public Screen(int number, int clipboard, int time){
        this.number = number;
        this.clipboard = clipboard;
        this.time = time;
    }
}