import java.util.Scanner;

//왜안되는지 모르겠음
public class N_1707 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        while(N-->0){
            int V = scan.nextInt();
            int E = scan.nextInt();
            boolean[][] edge = new boolean[V+1][V+1];
            NODE[] node = new NODE[V+1];
            for(int j=1; j<=V; j++){
                node[j] = new NODE(Color.None, j);
            }
            for(int j=1; j<=E; j++){
                int H = scan.nextInt();
                int W = scan.nextInt();
                edge[H][W] = true;
                edge[W][H] = true;
            }
            node[1].color = Color.Red;
            dfs(1, edge, V, node);
            scan(node, V, edge);
        }
    }

    static void dfs(int startN,boolean[][] edge, int n, NODE[] node){

        for(int i=1; i<=n; i++){
            if(node[i].color != Color.None || !edge[startN][i])
                continue;
            if(node[startN].color == Color.Red){
                node[i].color = Color.Blue;
            } else
                node[i].color = Color.Red;
            dfs(i, edge, n, node);
        }
    }

    static void scan(NODE[] node, int V, boolean[][] edge){
        boolean found = false;
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(edge[i][j] == true && node[i].color == node[j].color){
                    found = true;
                }
            }
        }
        if(found == true)
            System.out.println("No");
        else
            System.out.println("YES");
    }
}

class NODE{
    Color color;
    int value;
    public NODE(Color c, int value){
        this.color = c;
        this.value = value;
    }
}

enum Color{
    None,
    Red,
    Blue
}
