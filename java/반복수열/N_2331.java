import java.util.Scanner;

public class N_2331 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        String A = Integer.toString(a);
        int P = scan.nextInt();
        int[] DP = new int[60000];
        DP[1] = Integer.parseInt(A);
        for(int i=2; i<60000; i++){
            boolean f = false;
            String B = Integer.toString(DP[i-1]);
            for(int j=B.length(); j>0; j--){
                if ( j == B.length())
                    DP[i] += Math.pow((int)(DP[i-1]/Math.pow(10, j-1)), P);
                else{
                    DP[i] += Math.pow((int)((DP[i-1]-((int)(DP[i-1]/Math.pow(10, j)))*Math.pow(10, j))/Math.pow(10, j-1)), P);
                }
            }
            for(int j = 1; j<i; j++){
                if (i != j && DP[i] == DP[j]){
                    System.out.println(j-1);
                    f = true;
                    break;
                }
            }
            if (f)
                break;
        }
    }
}
