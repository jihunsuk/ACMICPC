import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJam02 {
    static int index = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for(int i=0; i<T; i++){
            int V = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            String[] arr = str.split(" ");
            int[] array = new int[arr.length];
            for(int j=0; j<array.length; j++){
                array[j] = Integer.parseInt(arr[j]);
            }
            solve(array);
            index++;
        }
    }
    static void solve(int[] Arr){
        boolean change = true;
        while(change){
            boolean c = false;
            for(int i=0; i<Arr.length-2; i++){
                if (Arr[i] > Arr[i+2]){
                    swap(Arr, i, i+2);
                    c = true;
                }
            }
            if(!c)
                change = false;
        }
        valid(Arr);
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void valid(int[] Arr){
        for(int i=0; i<Arr.length-1; i++){
            if(Arr[i] > Arr[i+1]){
                System.out.println("Case #"+index+": "+i);
                break;
            }
            if (i == Arr.length-2)
                System.out.println("Case #"+index+": OK");
        }
    }
}
