import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class NHN_2018_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int C = Integer.parseInt(br.readLine());

        LinkedList<Integer> cards = new LinkedList<Integer>();
        for(int i=1; i<=C; i++)
            cards.offer(i);

        final int P = Integer.parseInt(br.readLine());
        for(int i=0; i<P; i++){
            int N = Integer.parseInt(br.readLine());
            suffle(cards, N);
        }
        for(int i=0; i<5; i++)
            System.out.println(cards.get(i));
    }
    public static void suffle(LinkedList<Integer> cards, int N) {
        LinkedList<Integer> first = new LinkedList<Integer>();
        LinkedList<Integer> last = new LinkedList<Integer>();
        for(int i=0; i<N; i++){
            first.offer(cards.removeFirst());
            last.offer(cards.removeLast());
        }
        if(cards.size() > 2*N){
            suffle(cards, N);
        }

        for(int i=0; i<N; i++){
            cards.offer(first.removeFirst());
        }
        for(int i=0; i<N; i++){
            cards.offer(last.removeLast());
        }
    }
}
