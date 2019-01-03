import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String arr[] = br.readLine().split(" ");
    String arr2[] = br.readLine().split(" ");
    int N = Integer.parseInt(arr[0]);
    int k = Integer.parseInt(arr[1]);
    int[] array = new int[N];
    for(int i=0; i<N; i++){
      array[i] = Integer.parseInt(arr2[i]);
    }
    double min_e = Double.MAX_VALUE;
    for(int i=k; i<=N; i++){
      for(int j=0; j<N-i+1; j++){
        double sum = 0;
        for(int m=0; m<i; m++)
          sum += array[j+m];
        double mean = sum/(double)i;
        sum = 0;
        for(int m=0; m<i; m++)
          sum += Math.pow(array[j+m] - mean,2);
        double variance = sum/(double)i;
        double e = Math.sqrt(variance);
        if (min_e > e)
          min_e = e;
      }
    }
    System.out.println(min_e);
  }
}
