import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(reader.readLine());
        for(int i=0; i<N; i++){
            String input[] = reader.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            transe(A, B);
        }

    }

    public static void transe(int before, int After){
        boolean[] visited = new boolean[10001];
        Queue<node> list = new LinkedList<node>();
        list.add(new node("", before));
        visited[before] = true;
        while(!list.isEmpty()) {
            node A = list.remove();
            if (!visited[D(A.Number)]){
                node B = new node(A.command+"D", D(A.Number));
                if (B.Number == After){
                    System.out.println(B.command);
                    break;
                }
                list.add(B);
                visited[D(A.Number)] = true;
            }
            if (!visited[S(A.Number)]){
                node B = new node(A.command+"S", S(A.Number));
                if (B.Number == After){
                    System.out.println(B.command);
                    break;
                }
                list.add(B);
                visited[S(A.Number)] = true;
            }
            if (!visited[L(A.Number)]){
                node B = new node(A.command+"L", L(A.Number));
                if (B.Number == After){
                    System.out.println(B.command);
                    break;
                }
                list.add(B);
                visited[L(A.Number)] = true;
            }
            if (!visited[R(A.Number)]){
                node B = new node(A.command+"R", R(A.Number));
                if (B.Number == After){
                    System.out.println(B.command);
                    break;
                }
                list.add(B);
                visited[R(A.Number)] = true;
            }
        }
    }
    public static int D(int A){
        return A*2 % 10000;
    }
    public static int S(int A){
        return (A == 0) ? 9999: A-1;
    }
    public static int L(int A){
        return (A % 1000) * 10 + A / 1000;
    }
    public static int R(int A){
        return (A % 10) * 1000 + (A / 10);
    }
}

class node {
    public String command;
    public int Number;
    node(String command, int Number){
        this.command = command;
        this.Number = Number;
    }
}