package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String input = reader.readLine();
    int N = Integer.parseInt(input);
    Stack stack = new Stack();
    for(int i=0; i<N; i++){
      String[] input2 = reader.readLine().split(" ");
      if(input2[0].equals("push"))
        stack.push(Integer.parseInt(input2[1]));
      else if(input2[0].equals("top"))
        System.out.println(stack.top());
      else if(input2[0].equals("size"))
        System.out.println(stack.size());
      else if(input2[0].equals("empty"))
        System.out.println(stack.empty());
      else if(input2[0].equals("pop"))
        System.out.println(stack.pop());
    }
    reader.close();
  }
}

class Stack {
  private int[] arr;
  private int top;

  public Stack() {
    this.arr = new int[100001];
    top = -1;
  }

  public void push(int x){
    arr[++top] = x;
  }
  public int pop(){
    if (this.empty() == 1) return -1;
    else {
      int remove = arr[top--];
      return remove;
    }
  }
  public int size(){
    return this.top+1;
  }
  public int empty(){
    if(this.size() == 0)
      return 1;
    return 0;
  }
  public int top(){
    return this.empty() == 1 ? -1 : arr[top];
  }

}
