package 순열사이클;
//N_10451

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int ans;
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    int testCase = Integer.parseInt(input);
    for(int i=0; i<testCase; i++){
      int size = Integer.parseInt(reader.readLine());
      cycleCheck(reader.readLine().split(" "), size);
    }
  }
  public static void cycleCheck(String[] arr, int length){
    boolean[][] graph = new boolean[length][length];
    boolean[] visited = new boolean[length];
    ans = 0;

    for(int i=0; i<arr.length; i++){
      graph[i][Integer.parseInt(arr[i])-1] = true;
    }

    for(int i=0; i<arr.length; i++){
      for(int j=0; j<arr.length; j++) {
        if (!visited[j] && graph[i][j]) {
          dfs(i, j, graph, visited);
          }
      }
    }
    System.out.println(ans);
  }

  public static void dfs(int start, int current, boolean[][] graph, boolean[] visited) {
    visited[current] = true;
    if(start == current){
      ans++;
      return;
    } else {
      for(int i=0; i<graph.length; i++){
        if(!visited[i] && graph[current][i])
          dfs(start, i, graph, visited);
      }
    }
  }
}
