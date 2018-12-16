import java.util.ArrayList;
//import java.lang;

class Bridge {

    ArrayList<Integer>arr[];
    boolean[] visited;
    int[] inTime;
    int[] fuv;
    int[] parent;
    int time;

    Bridge(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        inTime = new int[size];
        fuv = new int[size];
        parent = new int[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
    }

    void addEdge(int u, int v) {
        arr[u].add(v);
        arr[v].add(u);
    }

    void BridgeUtil(int u) {
        visited[u] = true;
        inTime[u] = fuv[u] = ++time;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                parent[v] = u;
                BridgeUtil(v);
                fuv[u] = java.lang.Math.min(fuv[v], fuv[u]);
                if(fuv[v] > inTime[u]) {
                    System.out.println(u + "--->" + v);
                }
            }
            else if(v != parent[u]) {
                fuv[u] = java.lang.Math.min(fuv[u], inTime[v]);
            }
        }
    }

    void Bridge() {
        for(int i=0; i<arr.length; i++) {
            BridgeUtil(i);
        }
    }

    public static void main(String[] args) {
        Bridge g1 = new Bridge(5);
        System.out.println("Bridges in first graph");
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.Bridge();

        System.out.println("Bridges in second graph");
        Bridge g2 = new Bridge(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.Bridge();
  
        System.out.println("Bridges in third graph"); 
        Bridge g3 = new Bridge(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.Bridge(); 
    }

}
