import java.util.PriorityQueue;
import java.util.Scanner;

public class N_11404 {
    static int[][] edge;
    static int[] distance;
    static int v;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        v = scan.nextInt();
        int e = scan.nextInt();
        edge = new int[v+1][v+1];
        distance = new int[v+1];
        for(int i=0; i<e; i++){
            int h = scan.nextInt();
            int w = scan.nextInt();
            int weight = scan.nextInt();
            if (edge[h][w] == 0 || (edge[h][w]!=0 && edge[h][w] > weight ))
                edge[h][w] = weight;
        }
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                solve(i, j);
            }
            System.out.println();
        }
    }
    static void solve(int s, int e){
        for(int i=1; i<=v; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        q.offer(new Edge(s, distance[s]));
        while(!q.isEmpty()){
            int nowE = q.peek().getE();
            int nowW = q.peek().getW();
            q.poll();
            for(int i=1; i<=v; i++){
                if(edge[nowE][i] != 0){
                    if(distance[i] > distance[nowE] + edge[nowE][i]) {
                        distance[i] = distance[nowE] + edge[nowE][i];
                        q.offer(new Edge(i, distance[i]));
                    }
                }
            }
        }
        if(distance[e] == Integer.MAX_VALUE)
            System.out.print(0+" ");
        else
            System.out.print(distance[e]+" ");
    }
}

class Edge implements Comparable<Edge>{
    private int e;
    private int w;

    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }
    public int getE(){
        return e;
    }
    public int getW() {
        return w;
    }

    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}