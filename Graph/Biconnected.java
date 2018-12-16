import java.util.ArrayList;
import java.util.Stack;

class Biconnected {

    ArrayList<Integer>arr[];
    boolean[] visited;
    int[] inTime;
    int[] fuv;
    int[] parent;
    int time;
    Stack<Pair>stk;

    Biconnected(int size) {
        arr = new ArrayList[size];
        visited = new boolean[size];
        inTime = new int[size];
        fuv = new int[size];
        parent = new int[size];
        stk = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
            parent[i] = -1;
        }
    }

    private class Pair {
        int u;
        int v;
        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    void addEdge(int u, int v) {
        arr[u].add(v);
    }

    void BiccComp(int u) {
        visited[u] = true;
        int children = 0;
        inTime[u] = fuv[u] = ++time;
        for(int i=0; i<arr[u].size(); i++) {
            int v = arr[u].get(i);
            if(!visited[v]) {
                Pair pair = new Pair(u, v);
                stk.push(pair);
                children++;
                parent[v] = u;
                BiccComp(v);
                fuv[u] = java.lang.Math.min(fuv[u], fuv[v]);
                if((parent[v] == -1 && children > 1) || (parent[v] != -1 && fuv[v] >= inTime[u])) {
                    Pair res = stk.peek();
                    while(res.u != u || res.v != v) {
                        //air res = stk.peek();
                        System.out.print(res.u + " --> " + res.v + " ");
                        stk.pop();
                        res = stk.peek();
                    }
                    System.out.println(res.u + "-->" + res.v);
                    stk.pop();
                }
                /*else if(parent[v] != -1 && fuv[v] >= inTime[u]) {
                    Pair res = stk.peek();
                    while(res.u != u || res.v != v) {
                        //Pair res = stk.peek();
                        System.out.print(res.u + " --> " + res.v + " ");
                        stk.pop();
                        res = stk.peek();
                    }
                }*/
            }
            else if(v != parent[u]) {
                fuv[u] = java.lang.Math.min(fuv[u], inTime[v]);
                if(inTime[v] < inTime[u]) {
                    Pair pair = new Pair(u, v);
                    stk.push(pair);
                }
            }
        }
    }

    void BCC() {
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                BiccComp(i);
                while(!stk.isEmpty()) {
                    Pair p = stk.peek();
                    stk.pop();
                    System.out.print(p.u + " --> " + p.v + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Biconnected g = new Biconnected(12);
        g.addEdge(0, 1); 
        g.addEdge(1, 0); 
        g.addEdge(1, 2); 
        g.addEdge(2, 1); 
        g.addEdge(1, 3); 
        g.addEdge(3, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 2); 
        g.addEdge(2, 4); 
        g.addEdge(4, 2); 
        g.addEdge(3, 4); 
        g.addEdge(4, 3); 
        g.addEdge(1, 5); 
        g.addEdge(5, 1); 
        g.addEdge(0, 6); 
        g.addEdge(6, 0); 
        g.addEdge(5, 6); 
        g.addEdge(6, 5); 
        g.addEdge(5, 7); 
        g.addEdge(7, 5); 
        g.addEdge(5, 8); 
        g.addEdge(8, 5); 
        g.addEdge(7, 8); 
        g.addEdge(8, 7); 
        g.addEdge(8, 9); 
        g.addEdge(9, 8); 
        g.addEdge(10, 11); 
        g.addEdge(11, 10); 
        g.BCC(); 
    }
}
