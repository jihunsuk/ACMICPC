package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String input = reader.readLine();
    int numberOfCity = Integer.parseInt(input);
    int[][] map = new int[numberOfCity+1][numberOfCity+1];
    for(int i=1; i<=numberOfCity; i++){
      for(int j=1; j<=numberOfCity; j++){
        if(i == j) map[i][j] = 0;
        else
          map[i][j] = 10000000;
      }
    }

    input = reader.readLine();
    int numberOfBus = Integer.parseInt(input);
    for(int i=0; i<numberOfBus; i++){
      String[] input2 = reader.readLine().split(" ");
      int startIndex = Integer.parseInt(input2[0]);
      int endIndex = Integer.parseInt(input2[1]);
      if(map[startIndex][endIndex] > Integer.parseInt(input2[2]))
        map[startIndex][endIndex] = Integer.parseInt(input2[2]);
    }

    for (int k = 1; k <=numberOfCity; ++k) {
      for (int i = 1; i <=numberOfCity; ++i) {
        for (int j = 1; j <=numberOfCity; ++j) {
          if (map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }

    for(int i=1; i<=numberOfCity; i++){
      for(int j=1; j<=numberOfCity; j++){
        if (map[i][j] == 10000000) System.out.print(0+" ");
        else
          System.out.print(map[i][j]+" ");
      }
      System.out.println();
    }

  }
}
