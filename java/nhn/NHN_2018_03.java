import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class NHN_2018_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<input.length; i++){
            cost[i] = Integer.parseInt(input[i]);
        }

        LinkedList<Integer> benefit = new LinkedList<Integer>();
        int sum = 0;
        int maxIndex = -1;
        for(int i=0; i<cost.length; i++){
            int tmp = cost[i];

            if (maxIndex != -1 && i == maxIndex){
                int length= benefit.size();
                for(int j=0; j<length; j++){
                    int a = benefit.remove();
                    sum += (tmp-a);
                }
                sum -= 1;
            } else{
                boolean b = false;
                int max = -1;

                for(int j=i+1; j<cost.length; j++){
                    if(tmp <= cost[j]){
                        b = true;
                        if(max <= cost[j]){
                            maxIndex = j;
                            max = cost[j];
                        }
                    }
                }
                if (b){
                    benefit.offer(tmp);
                }
            }
        }
        System.out.println(sum);
    }
}
