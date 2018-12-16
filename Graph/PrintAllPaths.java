import java.util.ArrayList;

class PrintAllPaths {

    ArrayList<Integer>arr[];
    boolean[] visited;
    PrintAllPaths(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0; i<size; i++) {
           arr[i] = new ArrayList<Integer>();
        }
    }

    void add(int u, int v) {
        arr[u].add(v);
    }

    int index;

    void DFSUtil(int u, int des, int[] path) {
        visited[u] = true;
        path[index] = u;
        index++;
        if(u == des) {
           for(int j=0; j<index; j++) {
               System.out.print(path[j] + " ");
           }
           System.out.println();
        }

        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                DFSUtil(v, des, path);
            }
        }
        visited[u] = false;
        index--;
    }

    void DFS() {
        int src = 2;
        int des = 3;
        int[] path = new int[arr.length];
        DFSUtil(src, des, path);
    }

    public static void main(String[] args) {
        PrintAllPaths obj = new PrintAllPaths(4);
        obj.add(0, 1);
        obj.add(0, 2);
        obj.add(0, 3);
        obj.add(2, 0);
        obj.add(2, 1);
        obj.add(1, 3);
        obj.DFS();
    }
}
