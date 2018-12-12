import java.util.PriorityQueue;

class ConnectRopes {

    void ConnectCost(int[] arr) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        while(pq.size() > 1) {
            int val = pq.poll()+pq.poll();
            sum = sum + val;
            pq.add(val);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        ConnectRopes obj = new ConnectRopes();
        int[] arr = new int[]{4, 3, 2, 6};
        obj.ConnectCost(arr);
    }

}
