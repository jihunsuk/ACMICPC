import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        while(!str.equals("0")){
            int N = Integer.parseInt(str);
            System.out.println(solve(N));
            str = reader.readLine();
        }

    }
    public static int solve(int N){
        int Start = N;
        int End = 2*N;
        int Count = 0;
        boolean b[] = new boolean[End+1];
        for(int i=2; i<=End; i++){
            if(b[i] == false){
                if(i > Start && End >= i)
                    Count++;
                for(int j=1; j*i<=End; j++){
                    b[i*j] = true;
                }
            }
        }
        return Count;
    }
}
