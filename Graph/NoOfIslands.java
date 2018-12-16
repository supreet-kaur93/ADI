class NoOfIslands {

    boolean[][] visited;
    int[] row = new int[]{0, 0, 1, -1, 1, -1, -1, 1};
    int[] column = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
    
    void check(int[][]a, int i, int j) {
        if(i<0 || i >= a.length) {
            return;
        }
        if(j<0 || j>=a[i].length) {
            return;
        }
        if(a[i][j] != 1 || visited[i][j]) {
            return;
        }
        a[i][j] = -1;
        visited[i][j] = true;
        for(int x=0; x<row.length; x++) {
            check(a, i + row[x], j + column[x]);
        }
    }
    
    public static int findisland(int[][]a,int n,int m)
    {   
        NoOfIslands obj = new NoOfIslands();
        obj.visited = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a[i][j] == 1 && !obj.visited[i][j]) {
                    obj.check(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{ {1, 1, 0},
                                   {0, 0, 1},
                                   {1, 0, 1} };
        int res = findisland(arr, 3, 3);
        System.out.println(res);
    }

}
