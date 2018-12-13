import java.util.Map;
import java.util.HashMap;

class LongestIncSubSeq {

    void FindSubSeq(int[] arr) {
        int maxVal = 0;
        int max = 0;
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(map.get(val-1) == null) {
                map.put(val, 1);
                if(1 > max) {
                    max = 1;
                    maxVal = val;
                }

            }
            else {
                int x = map.get(val-1);
                map.put(val, x+1);
                if(x+1 > max) {
                    max = x+1;
                    maxVal = val;
                }
            }
        }
        for(int i=maxVal-max +1; i<=maxVal; i++) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        LongestIncSubSeq obj = new LongestIncSubSeq();
        int[] arr = new int[]{3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
        obj.FindSubSeq(arr);
    }
}
