import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Line_2018_03 {
    static int[] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        map = new int[1001];
        LinkedList<Integer>[] info = new LinkedList[n];
        Set<Integer> set = new HashSet<Integer>();
        boolean error = false;
        for (int i=0; i<n; i++){
            final StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            info[i] = new LinkedList<Integer>();
            while(tokenizer.hasMoreTokens()) {
                int fork = Integer.parseInt(tokenizer.nextToken());
                info[i].offer(fork);
                set.add(fork);
            }

            for (int j=0; j<info[i].size()-1; j++){
                if(map[info[i].get(j)] != 0){
                    if(map[info[i].get(j)] != info[i].get(j+1)){
                        error = true;
                        break;
                    }
                } else{
                    map[info[i].get(j)] = info[i].get(j+1);
                }
            }
            if (error){
                System.out.println(-1);
                break;
            }
        }
        if (!error){
            Set<Integer> ans = new HashSet<Integer>();
            for(int s : set){
                int startIndex = s;
                while(map[startIndex] != 0)
                    startIndex = map[startIndex];
                ans.add(startIndex);
            }

            ArrayList<Integer> answers = new ArrayList(ans);
            Collections.sort(answers);
            for(int answer : answers){
                System.out.print(answer+" ");
            }
        }


    }


}


