import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    void FindNo(int[] arr, int k) {
        PriorityQueue<Integer>PQ = new PriorityQueue<>(new Comparator<Integer>(){
             public int compare(Integer a, Integer b) {
                 return -1*a.compareTo(b);
             }
        });
        for(int i=0; i<arr.length; i++) {
            PQ.add(arr[i]);
        }
        while(k>1) {
            PQ.remove();
            k--;
        }
        System.out.println(PQ.peek());
    }

    public static void main(String[] args) {
        int sz = 5;
        int k = 3;
        int[] arr = new int[sz];
        KthLargest obj = new KthLargest();
        for(int i=0; i<5; i++) {
            arr[i] = i+1;
        }
        obj.FindNo(arr, k);
    }

}
