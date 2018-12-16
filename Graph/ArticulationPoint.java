// 1. u is root of DFS tree and it has at least two children.
// 2. u is not root of DFS tree and it has a child v such that
//    no vertex in subtree rooted with v has a back edge to
//    one of the ancestors (in DFS tree) of u.

import java.util.ArrayList;

class ArticulationPoint {

    ArrayList<Integer>arr[];
    boolean[] ap;
    boolean[] visited;
    int[] parent;
    int[] fuv;
    int[] inTime;
    int time;

    @SuppressWarnings("unchecked")
    ArticulationPoint(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        ap = new boolean[size];
        fuv = new int[size];
        inTime = new int[size];
        parent = new int[size];
        for(int i=0; i<arr.length; i++) {
            parent[i] = -1;
            arr[i] = new ArrayList<Integer>();
        }
    }

    void addEdge(int u, int v) {
        arr[u].add(v);
        arr[v].add(u);
    }

    void ArticulationPt(int u) {
        visited[u] = true;
        int children = 0;
        inTime[u] = fuv[u] = ++time;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
               children++;
               parent[v] = u;
               ArticulationPt(v);
               fuv[u] = java.lang.Math.min(fuv[u], fuv[v]);
               if(parent[u] == -1 && children > 1) {
                   ap[u] = true;
               }
               if(parent[u] != -1 && fuv[v] > inTime[u]) {
                   ap[u] = true;
               }
            }
            else if(v != parent[u]) {
                fuv[u] = java.lang.Math.min(fuv[u], inTime[v]);
            }
        }
    }

    void AP() {
        for(int i=0; i<arr.length; i++) {
            if(visited[i] == false) {
                ArticulationPt(i);
            }
        }
        for(int i=0; i<ap.length; i++) {
            if(ap[i] == true)
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
         System.out.println("Articulation points in first graph");
         ArticulationPoint g1 = new ArticulationPoint(5);
         g1.addEdge(1, 0);
         g1.addEdge(0, 2);
         g1.addEdge(2, 1);
         g1.addEdge(0, 3);
         g1.addEdge(3, 4);
         g1.AP();
  
         System.out.println("Articulation points in second graph");
         ArticulationPoint g2 = new ArticulationPoint(4);
         g2.addEdge(0, 1);
         g2.addEdge(1, 2);
         g2.addEdge(2, 3);
         g2.AP();
  
         System.out.println("Articulation points in third graph");
         ArticulationPoint g3 = new ArticulationPoint(7);
         g3.addEdge(0, 1);
         g3.addEdge(1, 2);
         g3.addEdge(2, 0);
         g3.addEdge(1, 3);
         g3.addEdge(1, 4);
         g3.addEdge(1, 6);
         g3.addEdge(3, 5);
         g3.addEdge(4, 5);
         g3.AP();
    }
}
