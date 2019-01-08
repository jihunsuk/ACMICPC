package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String input = reader.readLine();
    int N = Integer.parseInt(input);
    Queue queue = new Queue();
    for(int i=0; i<N; i++){
      String[] input2 = reader.readLine().split(" ");
      if(input2[0].equals("push"))
        queue.push(Integer.parseInt(input2[1]));
      else if(input2[0].equals("front"))
        System.out.println(queue.front());
      else if(input2[0].equals("back"))
        System.out.println(queue.back());
      else if(input2[0].equals("size"))
        System.out.println(queue.size());
      else if(input2[0].equals("empty"))
        System.out.println(queue.empty());
      else if(input2[0].equals("pop"))
        System.out.println(queue.pop());
    }
    reader.close();
  }
}

class Queue {
  private LinkedList<Integer> list;

  public Queue() {
    this.list = new LinkedList<Integer>();
  }

  public void push(int x){
    list.add(x);
  }
  public int pop(){
    if (this.empty() == 1) return -1;
    else {
      int remove = list.removeFirst();
      return remove;
    }
  }
  public int size(){
    return list.size();
  }
  public int empty(){
    if(this.size() == 0)
      return 1;
    return 0;
  }
  public int front(){
    return this.empty() == 1 ? -1 : list.getFirst();
  }

  public int back(){
    return this.empty() == 1 ? -1 : list.getLast();
  }

}
