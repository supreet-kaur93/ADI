import java.util.ArrayList;
import java.util.Stack;

class StronglyConn {

    ArrayList<Integer>arr[];
    Stack<Integer>stk;
    boolean[] visited;

    StronglyConn(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0; i<size; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        stk = new Stack<>();
    }

    void DFS(int u) {
        visited[u] = true;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                //stk.push(v);
                DFS(v);
            }
        }
        stk.push(u);
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    StronglyConn Transpose() {
        StronglyConn obj = new StronglyConn(arr.length);
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].size(); j++) {
                int v = arr[i].get(j);
                //System.out.print(v + " ");
                obj.arr[v].add(i);
            }
        }
        return obj;
    }

    void DFSUtil(StronglyConn obj, int u) {
        obj.visited[u] = true;
        System.out.print(u + " ");
        for(int i=0; i<obj.arr[u].size(); i++) {
            int v = obj.arr[u].get(i);
            if(!obj.visited[v]) {
                DFSUtil(obj, v);
            }
        }
    }

    void Connected() {
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                DFS(i);
            }
        }
        StronglyConn obj = Transpose();
        while(!stk.isEmpty()) {
            int v = stk.peek();
            stk.pop();
            if(!obj.visited[v]) {
                DFSUtil(obj, v);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StronglyConn obj = new StronglyConn(5);
        obj.add(1, 0);
        obj.add(0, 2);
        obj.add(2, 1);
        obj.add(0, 3);
        obj.add(3, 4);
        obj.Connected();
    }
}
