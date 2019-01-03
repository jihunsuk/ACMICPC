//http://spillmoon.tistory.com/180 참고했음.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_1697 {
    static int N;
    static int K;
    static int[] map = new int[100001];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        bfs();
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        map[N] = 1;
        while(!q.isEmpty()){
            int v = q.remove();
            if(v == K){
                System.out.println(map[v]-1);
            } else{
                if (v*2 <= 100000 && map[v*2] == 0){
                    map[v*2] = map[v]+1;
                    q.add(v*2);
                }
                if (v+1 <= 100000 && map[v+1] == 0){
                    map[v+1] = map[v]+1;
                    q.add(v+1);
                }
                if(v-1 >= 0 && map[v-1] == 0){
                    map[v-1] = map[v]+1;
                    q.add(v-1);
                }
            }
        }
    }
}