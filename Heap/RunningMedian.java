import java.util.PriorityQueue;
import java.util.Comparator;

class RunningMedian {

    void FindMedian(int[] arr) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        PriorityQueue<Integer>PQ = new PriorityQueue<>(new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                return -1*a.compareTo(b);
            }
        });
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(pq.size() == PQ.size()) {
                if(PQ.isEmpty() == true) {
                    PQ.add(val);
                }
                else {
                    if(PQ.peek() > val) {
                        PQ.add(val);
                    }
                    else pq.add(val);
                }
            }
            else if(PQ.size() > pq.size()) {
                if(PQ.peek() > val) {
                    pq.add(PQ.poll());
                    PQ.add(val);
                }
                else {
                    pq.add(val);
                }
           }
           else {
               if(pq.peek() < val) {
                   PQ.add(pq.poll());
                   pq.add(val);
               }
               else {
                   PQ.add(val);
               }
           }
           if(pq.size() == PQ.size()) {
               System.out.println((double)(pq.peek() + PQ.peek())/2 + " ");
           }
           else if(pq.size() > PQ.size()) {
               System.out.println(pq.peek() + " ");
           }
           else System.out.println(PQ.peek() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        RunningMedian obj = new RunningMedian();
        obj.FindMedian(arr);
    }
}
