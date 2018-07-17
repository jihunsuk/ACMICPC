import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UCPC2018_A_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        long N = Long.parseLong(str);
        System.out.println(N*4);
    }
}
