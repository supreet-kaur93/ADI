import java.util.PriorityQueue;

class SmallestDerangement {

    void Dearrange(int n) {
        int[] arr = new int[n];
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
            pq.add(arr[i]);
        }
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            int val = pq.poll();
            if(val != arr[i] || i == n-1) {
                res[i] = val;
            }
            else {
                res[i] = pq.poll();
                pq.add(val);
            }
        }
        if(res[n-1] == arr[n-1]) {
            int temp = res[n-1];
            res[n-1] = res[n-2];
            res[n-2] = temp;
        }
        for(int i=0; i<n; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        SmallestDerangement obj = new SmallestDerangement();
        obj.Dearrange(3);
    }
}
