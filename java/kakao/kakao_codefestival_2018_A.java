import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
  static int[] money = {0,500,300,300,200,200,200,50,50,50,50,30,30,30,30,30,10,10,10,10,10,10};
  static int[] money2 = {0,512,256,256,128,128,128,128,64,64,64,64,64,64,64,64,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for(int i=0; i<N; i++){
      String arr[] = br.readLine().split(" ");
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      int sum = 0;
      if (a != 0 && a <= 21)
        sum += money[a];
      if (b !=0  && b<=31)
        sum+= money2[b];
      if (sum != 0) System.out.println(sum + "0000");
      else if (sum == 0) System.out.println(0);
    }
  }
}
