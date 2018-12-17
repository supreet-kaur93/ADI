import java.util.ArrayList;

class Bipartite {

    ArrayList<Integer>arr[];
    boolean[] visited;
    boolean[] color;
    boolean res;

    @SuppressWarnings("unchecked")
    Bipartite(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        color = new boolean[size];
        for(int i=0; i<size; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        res = false;
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    void CheckBipartite(int u, boolean COLOR) {
        visited[u] = true;
        color[u] = COLOR;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(visited[v]) {
                if(color[v] == color[u]) {
                    res = true;
                }
            }
            else {
                CheckBipartite(v, !COLOR);
            }
        }
    }

    boolean BPGraph() {
        CheckBipartite(0, false);
        if(res == true) {
            return false;
        }
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Bipartite obj = new Bipartite(4);
        obj.add(0, 1);
        obj.add(0, 3);
        obj.add(1, 0);
        obj.add(1, 2);
        obj.add(2, 1);
        obj.add(2, 3);
        obj.add(3, 0);
        obj.add(3, 2);
        boolean res = obj.BPGraph();
        System.out.println(res);
    }
}
