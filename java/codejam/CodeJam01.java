import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJam01 {
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int T = Integer.parseInt(str);
        for(int i=0; i<T; i++){
            str = reader.readLine();
            String[] s = str.split(" ");
            int D = Integer.parseInt(s[0]);
            String P = s[1];
            char[] newP = P.toCharArray();
            if(cal(newP) <= D){
                System.out.println("Case #"+index+": "+0);
                index++;
            }

            else
                solve(D, newP);
        }
    }

    public static void solve(int D, char[] P){
        int Count = 0;
        boolean find = false;
        int i = P.length - 1;
        while(!find) {
            if (P[i - 1] == 'C' && P[i] == 'S') {
                swap(P, i - 1, i);
                Count++;
                if (cal(P) <= D) {
                    System.out.println("Case #"+index+": "+Count);
                    index++;
                    break;
                }
                i = P.length - 1;
            } else{
                i--;
                if(i == 0) {
                    System.out.println("Case #"+index+": IMPOSSIBLE");
                    index++;
                    break;
                }
            }
        }
    }
    public static int cal(char[] P){
        int sum = 0;
        int Damage = 1;
        for(int i=0; i<P.length; i++){
            if (P[i] == 'S')
                sum += Damage;
            else if(P[i] == 'C')
                Damage *= 2;
        }
        return sum;
    }
    public static void swap(char[] P, int i, int j){
        char tmp = P[i];
        P[i] = P[j];
        P[j] = tmp;
    }
}
