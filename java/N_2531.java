import java.util.Scanner;

public class N_2531 {
    static int[] array = new int[33001];
    static int[] list;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int d = scan.nextInt();
        int k = scan.nextInt();
        int c = scan.nextInt();
        for(int i=1; i<=N; i++)
            array[i] = scan.nextInt();
        array[0] = array[N];
        int max = 0;
        for(int i=1; i<k; i++)
            array[N+i] = array[i];
        int temp;
        for(int i=1; i<=N; i++){
            list = new int[3001];
            list[c] = 1;
            temp = 1;
            for(int j=0; j<k; j++){
                if (list[array[i+j]] == 0) {
                    list[array[i + j]] = 1;
                    temp++;
                }
            }
            if (max < temp)
                max = temp;
        }
        System.out.println(max);
    }
}