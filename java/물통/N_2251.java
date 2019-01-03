import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//물통   from to 배열만들어서하면 좀더 짧게가능

public class N_2251 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = reader.readLine().split(" ");
        int max_A = Integer.parseInt(input[0]);
        int max_B = Integer.parseInt(input[1]);
        int max_C = Integer.parseInt(input[2]);

        boolean[][][] visited = new boolean[max_A+1][max_B+1][max_C+1];
        TreeSet<Integer> ans = new TreeSet<Integer>();

        Queue<multong> q = new LinkedList<multong>();
        q.add(new multong(0, 0, max_C));
        visited[0][0][max_C] = true;
        ans.add(max_C);

        while(!q.isEmpty()){
            multong current = q.poll();

            //c->a,
            if(current.A < max_A && current.C > 0){
                int nextA, remember_C;
                int remember_A = max_A - current.A;
                if(remember_A >= current.C){
                    nextA = current.A + current.C;
                    remember_C = 0;
                } else {
                    nextA = max_A;
                    remember_C = current.C-remember_A;
                }
                if(!visited[nextA][current.B][remember_C]){
                    q.add(new multong(nextA, current.B, remember_C));
                    visited[nextA][current.B][remember_C] = true;
                    if (nextA == 0)
                        ans.add(remember_C);
                }
            }
            //c->b
            if(current.B < max_B && current.C > 0){
                int nextB, remember_C;
                int remember_B = max_B - current.B;
                if(remember_B >= current.C){
                    nextB = current.B + current.C;
                    remember_C = 0;
                } else {
                    nextB = max_B;
                    remember_C = current.C-remember_B;
                }
                if(!visited[current.A][nextB][remember_C]){
                    q.add(new multong(current.A, nextB, remember_C));
                    visited[current.A][nextB][remember_C] = true;
                    if (current.A == 0)
                        ans.add(remember_C);
                }
            }
            //b->a
            if(current.A < max_A && current.B > 0){
                int nextA, remember_B;
                int remember_A = max_A - current.A;
                if(remember_A >= current.B){
                    nextA = current.A + current.B;
                    remember_B = 0;
                } else {
                    nextA = max_A;
                    remember_B = current.B-remember_A;
                }
                if(!visited[nextA][remember_B][current.C]){
                    q.add(new multong(nextA, remember_B, current.C));
                    visited[nextA][remember_B][current.C] = true;
                    if(nextA == 0)
                        ans.add(current.C);
                }
            }
            //b->c
            if(current.C < max_C && current.B > 0){
                int nextC, remember_B;
                int remember_C = max_C - current.C;
                if(remember_C >= current.B){
                    nextC = current.C + current.B;
                    remember_B = 0;
                } else {
                    nextC = max_C;
                    remember_B = current.B-remember_C;
                }
                if(!visited[current.A][remember_B][nextC]){
                    q.add(new multong(current.A, remember_B, nextC));
                    visited[current.A][remember_B][nextC] = true;
                    if(current.A == 0)
                        ans.add(nextC);
                }
            }
            //a->c
            if(current.C < max_C && current.A > 0){
                int nextC, remember_A;
                int remember_C = max_C - current.C;
                if(remember_C >= current.A){
                    nextC = current.C + current.A;
                    remember_A = 0;
                } else {
                    nextC = max_C;
                    remember_A = current.A-remember_C;
                }
                if(!visited[remember_A][current.B][nextC]){
                    q.add(new multong(remember_A, current.B, nextC));
                    visited[remember_A][current.B][nextC] = true;
                    if(remember_A == 0)
                        ans.add(nextC);
                }
            }
            //a->b
            if(current.B < max_B && current.A > 0){
                int nextB, remember_A;
                int remember_B = max_B - current.B;
                if(remember_B >= current.A){
                    nextB = current.B + current.A;
                    remember_A = 0;
                } else {
                    nextB = max_B;
                    remember_A = current.A-remember_B;
                }
                if(!visited[remember_A][nextB][current.C]){
                    q.add(new multong(remember_A, nextB, current.C));
                    visited[remember_A][nextB][current.C] = true;
                    if(remember_A == 0)
                        ans.add(current.C);
                }
            }
        }

        for(int answer : ans)
            System.out.print(answer+" ");

    }
}

class multong {
    public int A;
    public int B;
    public int C;
    public multong(int a, int b, int c){
        this.A = a;
        this.B = b;
        this.C = c;
    }
}