// Given Graph is directed Graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
class PathBetweenTwoVertices {

    ArrayList<Integer> arr[];
    boolean[] visited;

    PathBetweenTwoVertices(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    boolean FindPath(int s, int d) {
        Queue<Integer>queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()) {
            int u = queue.peek();
            queue.remove();
            for(int i=0; i<arr[u].size(); i++) {
                int v = arr[u].get(i);
                if(!visited[v]) {
                    visited[v] = true;
                    if(v == d) {
                        return true;
                    }
                    queue.add(v);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathBetweenTwoVertices obj = new PathBetweenTwoVertices(4);
        obj.add(0, 1);
        obj.add(0, 2);
        obj.add(1, 2);
        obj.add(2, 0);
        obj.add(2, 3);
        obj.add(3, 3);
        boolean res = false;
        res = obj.FindPath(1, 3);
        System.out.print("Is there path from 1 to 3 ----> ");
        System.out.println(res);
        res = obj.FindPath(3, 1);
        System.out.print("Is there path from 3 to 1 ----> ");
        System.out.println(res);
    }
}
