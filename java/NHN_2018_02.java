import java.io.*;
import java.util.LinkedList;

public class NHN_2018_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int W = Integer.parseInt(input[1]);
        String[][] pan = new String[N][N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                pan[i][j] = input[j];
            }
        }
        LinkedList<String>[] list = new LinkedList[N/2];
        int length = N;
        int length2 = N;
        for(int i=0; i<N/2; i++){
            list[i] = new LinkedList<String>();

            for(int j=i; j<length; j++){
                list[i].offer(pan[i][j]);
            }
            length -= 1;

            for(int j=i+1; j<length2; j++){
                list[i].offer(pan[j][N-i-1]);
            }
            length2 -= 1;

            for(int j=N-2-i; j>=i; j--){
                list[i].offer(pan[N-i-1][j]);
            }

            for(int j=N-i-2; j>=i+1; j--){
                list[i].offer(pan[j][i]);
            }
        }

        boolean clock = (W > 0);

        int current_N = N;
        for(int i=0; i<N/2; i++){
            int abs_W = Math.abs(W);

            int circle_number = abs_W % ((current_N-1)*4);
            if(clock){
                for(int j=0; j<circle_number; j++){
                    String tmp = list[i].removeLast();
                    list[i].addFirst(tmp);
                }
            } else{
                for(int j=0; j<circle_number; j++){
                    String tmp = list[i].removeFirst();
                    list[i].addLast(tmp);
                }
            }
            clock = !clock;
            current_N -= 2;
        }
        int length3 = N;
        int length4 = N;
        for(int i=0; i<list.length; i++){
            LinkedList<String> tmp = list[i];


            for(int j=i; j<length3; j++){
                pan[i][j] = tmp.removeFirst();
            }
            length3--;

            for(int j=i+1; j<length4; j++){
                pan[j][N-i-1] = tmp.removeFirst();
            }
            length4--;

            for(int j=N-i-2; j>=i; j--){
                pan[N-i-1][j] = tmp.removeFirst();
            }

            for(int j=N-i-2; j>i; j--){
                pan[j][i] = tmp.removeFirst();
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j == N-1)
                    System.out.println(pan[i][j]);
                else
                    System.out.print(pan[i][j]+" ");
            }
        }

    }
}
