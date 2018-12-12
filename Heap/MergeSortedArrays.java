import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class MergeSortedArrays {

   class Pair {
       int i;
       int j;
       Pair(int i, int j) {
           this.i = i;
           this.j = j;
       }
   }

    void Merge(int[][] arr) {
        ArrayList<Integer>res = new ArrayList<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return ((Integer)arr[a.i][a.j]).compareTo((Integer)arr[b.i][b.j]);
            }
        });
        for(int i=0; i<arr.length; i++) {
            Pair pair = new Pair(i, 0);
            pq.add(pair);
        }
        while(pq.size() >0 ) {
            Pair p = pq.poll();
            res.add(arr[p.i][p.j]);
            p.j = p.j+1;
            if(p.j < arr[p.i].length) {
                Pair nn = new Pair(p.i, p.j);
                pq.add(nn);
            }
        }
        for(int i=0; i<res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays obj = new MergeSortedArrays();
        int[][] arr = new int[][] {{1, 3, 5, 7},
                                   {2, 4, 6, 8},
                                   {0, 9, 10, 11}};
        obj.Merge(arr);
    }

}
