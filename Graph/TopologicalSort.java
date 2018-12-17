//topological sort is used for conneccted acyclic graph

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {

    ArrayList<Integer>arr[];
    boolean[] visited;
    Stack<Integer>stk;

    @SuppressWarnings("unchecked")
    TopologicalSort(int size) {
        visited = new boolean[size];
        arr = new ArrayList[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        stk = new Stack<Integer>();
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    void DFSUtil(int u) {
        visited[u] = true;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                DFSUtil(v);
            }
        }
        stk.add(u);
    }

    void Sort() {
        for(int i=0; i<arr.length; i++) {
            if(visited[i] == false) {
                DFSUtil(i);
            }
        }
        while(!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }
    }

     public static void main(String[] args) {
         TopologicalSort obj = new TopologicalSort(6);
         obj.add(5, 2);
         obj.add(5, 0);
         obj.add(4, 0);
         obj.add(4, 1);
         obj.add(2, 3);
         obj.add(3, 1);
         obj.Sort();
     }
}
