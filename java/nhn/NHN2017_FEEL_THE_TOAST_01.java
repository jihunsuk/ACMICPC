
import java.util.*;
import java.io.*;

public class NHN2017_FELL_THE_TOAST_01 {

    /**
     * @param args
     */
    static int N;
    static boolean[][] map;


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        map = new boolean[N+1][N+1];
        Sector root = new Sector(0, 5000, 5000, 5000);

        for(int i=1; i<=N; i++){
            String[] input = reader.readLine().split(" ");
            Sector newSector = new Sector(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]));

            root.addToList(newSector);
        }

        makeMap(root);

        String[] input = reader.readLine().split(" ");
        find(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

    }
    public static void makeMap(Sector parent) {
        int parentNumber = parent.getNumber();

        for(Sector child : parent.getList()) {
            int childNumber = child.getNumber();
            map[parentNumber][childNumber] = true;
            map[childNumber][parentNumber] = true;
            makeMap(child);
        }
    }

    public static void find(int start, int end) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(start, String.valueOf(start)));
        while(!q.isEmpty()){
            Node curNode = q.remove();
            int curNumber = curNode.getNumber();
            String curString = curNode.getAns();
            if(curNumber == end){
                System.out.print(curNode.getAns());
                break;
            }
            for(int i=0; i<=N; i++){
                if(map[curNumber][i]){
                    q.add(new Node(i, curString+" "+String.valueOf(i)));
                }
            }
        }
        System.out.print("-1");

    }

}

class Node {
    private int _number;
    private String _ans;
    public Node(int number, String ans){
        this._number = number;
        this._ans = ans;
    }
    public int getNumber() {
        return this._number;
    }
    public String getAns() {
        return this._ans;
    }
}


class Sector {
    private int _number;
    private int _x;
    private int _y;
    private int _radius;
    private LinkedList<Sector> _list;

    public Sector(int number, int x, int y, int radius){
        this._number = number;
        this._x = x;
        this._y = y;
        this._radius = radius;
        this._list = new LinkedList<Sector>();
    }

    public int getNumber() {
        return this._number;
    }
    public int getX(){
        return this._x;
    }
    public int getY() {
        return this._y;
    }
    public int getRadius(){
        return this._radius;
    }
    public LinkedList<Sector> getList(){
        return this._list;
    }

    public void addToList(Sector sector){
        boolean end = false;
        for(Sector s : this._list) {
            if(s.contains(sector)){
                end = true;
                s.addToList(sector);
            }
        }
        if (!end){
            this._list.add(sector);
        }

    }


    public boolean contains(Sector sector){
        return (this._x - this._radius) < sector.getX() && (this._x + this._radius) > sector.getX()
                && (this._y - this._radius) < sector.getY() && (this._y + this._radius) > sector.getY();
    }
}