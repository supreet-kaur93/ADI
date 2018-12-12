import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.ArrayList;

class MaxSumCombinations {

    void FindMaxSum(ArrayList<Integer>arl1, ArrayList<Integer>arl2, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        Collections.sort(arl1, new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                return -1* (a.compareTo(b));
            }
        });
        Collections.sort(arl2, new Comparator<Integer>() {
        
            public int compare(Integer a, Integer b) {
                return -1* (a.compareTo(b));
            }
        });
        int count = 0;
        for(int i=0; i<arl1.size(); i++) {
            for(int j=0; j<arl2.size(); j++) {
                int sum = arl1.get(i) + arl2.get(j);
                count++;
                if(count <= k) {
                    pq.add(sum);
                }
                else {
                    if(pq.peek() < sum) {
                        pq.poll();
                        pq.add(sum);
                    }
                    else break;
                }
            }
        }
        while(pq.size() > 0) {
            System.out.println(pq.poll() +" ");
        }
    }

    public static void main(String[] args) {
        MaxSumCombinations obj = new MaxSumCombinations();
        ArrayList<Integer>al = new ArrayList<>();
        al.add(4);
        al.add(2);
        al.add(5);
        al.add(1);
        ArrayList<Integer>al2 = new ArrayList<>();
        al2.add(8);
        al2.add(0);
        al2.add(3);
        al2.add(5);
        obj.FindMaxSum(al, al2, 4);
    }
}
