import java.util.ArrayList;

class Size {

    ArrayList<Integer>arr[];
    boolean[] visited;
    int[] size;

    Size(int size) {
        this.size = new int[size];
        arr = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
            this.size[i] = 1;
        }
    }

    void add(int parent, int child) {
        arr[parent].add(child);
        //arr[child].add(parent);
    }

    void DFSUtil(int u) {
        visited[u] = true;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                DFSUtil(v);
                size[u] = size[u] + size[v];
            }
        }
    }

    void Set() {
        for(int i=0; i<size.length; i++) {
            size[i] = 1;
            visited[i] = false;
        }
    }

    void SizeUtil() {
        for(int i=0; i<arr.length; i++) {
            Set();
            DFSUtil(i);
            System.out.println(i + "--->" + size[i]);
        }
    }

    public static void main(String[] args) {
        Size obj = new Size(8);
        obj.add(1, 2);
        obj.add(1, 3);
        obj.add(2, 5);
        obj.add(3, 4);
        obj.add(5, 6);
        obj.add(5, 4);
        obj.add(4, 7);
        obj.SizeUtil();
    }
}
