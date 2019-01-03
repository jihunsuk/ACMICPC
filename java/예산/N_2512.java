import java.util.Arrays;
import java.util.Scanner;

public class N_2512 {
private static int n = 0;
    private static int m = 0;
    private static int input = 0;
    private static int arr[];
    private static int count = 0;

    public static void main(String[] args){
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        count = n;
        arr = new int[n];
        for(int i=0; i<n; i++){
            input = sc.nextInt();
            arr[i] = input;
        }
        m = sc.nextInt();				// 예산의 한도
        Arrays.sort(arr);				// 오름차순 정렬
        process(0,m);
    }
    static int max = -1;
    public static void process(int start, int budget){
        int temp = budget;
        int idx = start;
        int average = temp/count;

        for(int i=start; i<n; i++){
            if(arr[i]<=average){
                m -=arr[i];	count--;
                if ( max < arr[i]) max = arr[i];
            }else{
                idx= i;	break;
            }
        }
        if(idx==start && count != 0)	System.out.println(m/count);
        else if(idx == start && count == 0) System.out.println(max);
        else process(idx, m);
    }
}
