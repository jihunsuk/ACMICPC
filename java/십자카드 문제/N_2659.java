import java.util.Scanner;

public class N_2659 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A[] = new int[4];
        for (int i = 0; i < 4; i++)
            A[i] = scan.nextInt();

        int a = A[0] * 1000 + A[1] * 100 + A[2] * 10 + A[3];
        int b = A[1] * 1000 + A[2] * 100 + A[3] * 10 + A[0];
        int c = A[2] * 1000 + A[3] * 100 + A[0] * 10 + A[1];
        int d = A[3] * 1000 + A[0] * 100 + A[1] * 10 + A[2];
        int min = Math.min(a, Math.min(b, Math.min(c, d)));
        int C = 0;
        for(int i= 1111; i<min; i++){
            int B[] = new int[4];
            B[0] = i/1000;
            B[1] = (i - B[0]*1000)/100;
            B[2] = (i-B[0]*1000-B[1]*100)/10;
            B[3] = i-B[0]*1000-B[1]*100-B[2]*10;
            if(B[0] == 0 || B[1] == 0 || B[2] == 0 || B[3] == 0)
                continue;
            int aa = B[0] * 1000 + B[1] * 100 + B[2] * 10 + B[3];
            int bb = B[1] * 1000 + B[2] * 100 + B[3] * 10 + B[0];
            int cc = B[2] * 1000 + B[3] * 100 + B[0] * 10 + B[1];
            int dd = B[3] * 1000 + B[0] * 100 + B[1] * 10 + B[2];
            int min2 = Math.min(aa, Math.min(bb, Math.min(cc, dd)));
            if (i==min2)
                C++;
        }
        System.out.println(C+1);
    }
}