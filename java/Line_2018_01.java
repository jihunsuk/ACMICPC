import java.util.Scanner;
import java.util.StringTokenizer;


public class Line_2018_01 {
    public static void main(String[] args){
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        int haveMoney = 20000;
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            int cost = cost(distance);
            if (cost == -1)
                break;
            if (haveMoney-cost < 0)
                break;
            haveMoney -= cost;
        }
        System.out.println(haveMoney);
    }
    public static int cost(int distance) {
        int currenct_cost = 720;
        if (distance < 4 || distance > 178)
            return -1;
        if (distance <= 40)
            return currenct_cost;
        else{
            double dist = (double)distance-40;
            double m = Math.ceil(dist / 8);
            currenct_cost += 80*m;
            return currenct_cost;
        }
    }
}

