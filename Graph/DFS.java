import java.util.ArrayList;

class DFS {

    boolean[] visited;
    ArrayList<Integer>arr[];
    int size;

    @SuppressWarnings("unchecked")
    DFS(int size) {
        this.size = size;
        arr = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
    }

    void add(int parent, int child) {
        arr[parent].add(child);
        arr[child].add(parent);
    }

    void TraverseDfs(int u) {
        visited[u] = true;
        System.out.print(u + " ");
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                TraverseDfs(v);
            }
        }
    }

    void Set() {
        for(int i=0; i<size; i++) {
            visited[i] = false;
        }
    }

    void Traverse() {
        for(int i=0; i<arr.length; i++) {
            System.out.print(i + "---->");
            TraverseDfs(i);
            Set();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DFS obj = new DFS(8);
        obj.add(1, 2);
        obj.add(1, 3);
        obj.add(2, 5);
        obj.add(3, 4);
        obj.add(5, 6);
        obj.add(6, 7);
        obj.Traverse();
    }
}
