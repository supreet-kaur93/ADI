import java.util.ArrayList;

class ConnComponents {

    ArrayList<Integer>arr[];
    boolean[] visited;
    ArrayList<Integer>res[];
    ConnComponents(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        res = new ArrayList[size];
        for(int i=0; i<size; i++) {
           arr[i] = new ArrayList<Integer>();
           res[i] = new ArrayList<Integer>();
        }
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    void DFSUtil(int u, int val) {
        visited[u] = true;
        res[val].add(u);
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                DFSUtil(v, val);
            }
        }
    }

    void DFS() {
        int val = 0;
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                DFSUtil(i, val);
                val++;
            }
        }
    }

    void display() {
        for(int i=0; i<res.length; i++) {
            for(int j=0; j<res[i].size(); j++) {
                System.out.print(res[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ConnComponents obj = new ConnComponents(7);
        obj.add(0, 1);
        obj.add(1, 2);
        obj.add(1, 3);
        obj.add(2, 4);
        obj.add(5, 6);
        obj.DFS();
        obj.display();
    }
}
