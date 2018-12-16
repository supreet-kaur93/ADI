import java.util.ArrayList;

class Depth {

    ArrayList<Integer>arr[];
    int[] Depth;
    boolean[] visited;

    Depth(int size) {
        arr = new ArrayList[size];
        Depth = new int[size];
        visited = new boolean[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
    }

    void add(int parent, int child) {
        arr[parent].add(child);
        arr[child].add(parent);
    }

    void DFSUtil(int u) {
        visited[u] = true;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                Depth[v] = Depth[u] + 1;
                DFSUtil(v);
            }
        }
    }

    void DepthUtil() {
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                DFSUtil(i);
            }
        }
        for(int i=0; i<Depth.length; i++) {
            System.out.println(i + "--->" + Depth[i]);
        }
    }

    public static void main(String[] args) {
        Depth obj = new Depth(8);
        obj.add(1, 2);
        obj.add(1, 3);
        obj.add(2, 5);
        obj.add(3, 4);
        obj.add(5, 6);
        obj.add(5, 4);
        obj.add(4, 7);
        obj.DepthUtil();
    }
}
