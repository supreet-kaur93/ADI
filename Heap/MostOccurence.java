import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class MostOccurence {

    class Pair {
        int count;
        int num;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    void FindNumber(int[] arr, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>(new Comparator<Pair>(){

            public int compare(Pair a, Pair b) {
                return -1*((Integer)a.count).compareTo((Integer)b.count);
            }
        });
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(map.get(val) == null) {
                map.put(arr[i], 1);
            }
            else {
                int count = map.get(val);
                map.put(val, count+1);
            }
        }
        for(Map.Entry<Integer, Integer>entry: map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            pq.add(pair);
        }
        while(k>0) {
            Pair pair = pq.poll();
            System.out.print(pair.num+" ");
            k--;
        }
    }

    public static void main(String[] args) {
        MostOccurence obj = new MostOccurence();
        int[] arr = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        obj.FindNumber(arr, 4);
    }
}
