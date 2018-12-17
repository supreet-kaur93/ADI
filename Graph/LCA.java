import java.util.ArrayList;

class LCA {

    ArrayList<Integer>arr[];
    boolean[] visited;
    int[] traversed;
    int[] parent;

    LCA(int size) {
        arr = new ArrayList[size];
        for(int i=0; i<size; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        visited = new boolean[size];
        traversed = new int[size];
        parent = new int[size];
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    void DFS(int u) {
        visited[u] = true;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                parent[v] = u;
                DFS(v);
            }
        }
    }

    void LCAUtil(int u, int v) {
        int res = 0;
        while(true) {
            traversed[u] = 1;
            if(u == 0) {
                break;
            }
            u = parent[u];
        }
        while(true) {
            if(traversed[v] == 1) {
                res = v;
                break;
            }
            v = parent[v];
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        //DFS(0);
        LCA obj = new LCA(10);
        //obj.DFS(0);
        obj.add(0, 1);
        obj.add(0, 7);
        obj.add(1, 2);
        obj.add(1, 3);
        obj.add(1, 6);
        obj.add(3, 4);
        obj.add(3, 5);
        obj.add(7, 8);
        obj.add(7, 9);
        obj.DFS(0);
        obj.LCAUtil(4, 1);
    }
}
