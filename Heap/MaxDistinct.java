import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Map;

class MaxDistinct {

   void FindDistinct(int[] arr, int k) {
       HashMap<Integer, Integer>map = new HashMap<>();
       for(int i=0; i<arr.length; i++) {
           int val = arr[i];
           if(map.get(val) == null) {
               map.put(val, 1);
           }
           else {
               int count = map.get(val);
               map.put(val, count+1);
           }
       }
       PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<Integer>() {

           public int compare(Integer a, Integer b) {
               return -1* a.compareTo(b);
           }
       });
       for(Map.Entry<Integer, Integer>entry: map.entrySet()) {
           pq.add(entry.getValue());
       }
       while(k>0) {
           int val = pq.poll();
           val--;
           if(val != 0) {
               pq.add(val);
           }
           k--;
       }
       System.out.println(pq.size());
   }

    public static void main(String[] args) {
        int[] arr=  new int[]{5, 7, 5, 5, 1, 2, 2};
        int k = 3;
        MaxDistinct obj = new MaxDistinct();
        obj.FindDistinct(arr, k);
    }

}
