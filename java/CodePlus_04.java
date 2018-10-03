import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class CodePlus_04 {
    static LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        final int sum = Integer.parseInt(reader.readLine());
        int[] number = new int[input.length];
        for(int i=0; i<input.length; i++){
            number[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(number);
        int[] arr = new int[number.length];
        combination(arr, 0, number.length, 3, 0);

        boolean find = false;
        for(LinkedList<Integer> li : list){
            int total = 0;
            for(int i : li){
                total += number[i];
            }
            if(total  == sum){
                find = true;
                System.out.println(number[li.get(0)]+" "+number[li.get(1)]+" "+number[li.get(2)]);
            }
        }
        if (!find)
            System.out.println("NO");
    }
    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0) add(arr, index);
        else if (target == n) return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }
    public static void add(int[] arr, int length) {
        LinkedList<Integer> L = new LinkedList<Integer>();
        for (int i = 0; i < length; i++){
            L.offer(arr[i]);
        }
        list.offer(L);
    }
}


