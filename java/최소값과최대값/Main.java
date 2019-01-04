package 최소값과최대값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input = reader.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    long[] arr = new long[N];
    for(int i=0; i<N; i++){
      arr[i] = Long.parseLong(reader.readLine());
    }

    int heightOfTree = (int)Math.ceil(Math.log(N)/Math.log(2));
    int treeSize = (int)Math.pow(2, heightOfTree+1);
    SegmentTree tree = new SegmentTree(arr, treeSize);

    for(int i=0; i<M; i++){
      input = reader.readLine().split(" ");
      int from = Integer.parseInt(input[0]);
      int to = Integer.parseInt(input[1]);
      System.out.print(tree.search(0, N-1, 1, from-1, to-1, "MIN")+" ");
      System.out.println(tree.search(0, N-1, 1, from-1, to-1, "MAX"));
    }
  }

}

class SegmentTree {
  long[] arr;
  Long[] maxTree;
  Long[] minTree;

  public SegmentTree(long[] arr, int treeSize) {
    this.arr = arr;
    this.maxTree = new Long[treeSize];
    this.minTree = new Long[treeSize];
    init(0, arr.length-1, 1, "MAX");
    init(0, arr.length-1, 1, "MIN");
  }

  public long init(int start, int end, int node, String type){
    if(start == end) {
      if(type.equals("MAX")){
        return this.maxTree[node] = this.arr[start];
      } else{
        return this.minTree[node] = this.arr[start];
      }
    } else {
      if(type.equals("MAX")){
        return this.maxTree[node] = Math.max(init(start, (start+end)/2, node*2, type),init((start+end)/2+1, end, node*2+1, type));
      } else{
        return this.minTree[node] = Math.min(init(start, (start+end)/2, node*2, type),init((start+end)/2+1, end, node*2+1, type));
      }
    }
  }

  public long search(int start, int end, int node, int left, int right, String type) {
    if(type.equals("MAX")){
      if(end < left || right<start)
        return Integer.MIN_VALUE;
      if(left <= start && right >= end) {
        return this.maxTree[node];
      }
      return Math.max(search(start, (start+end)/2, node*2, left,right, type),search((start+end)/2+1, end, node*2+1, left,right, type));
    } else {
      if(end < left || right<start)
        return Integer.MAX_VALUE;
      if(left <= start && right >= end) {
        return this.minTree[node];
      }
      return Math.min(search(start, (start+end)/2, node*2, left,right, type),search((start+end)/2+1, end, node*2+1, left,right, type));
    }
  }
}
