import java.util.HashMap;
import java.util.Map;

class DivideInPairs {

    boolean CountPairs(int[] arr, int k) {
        Map<Integer, Integer>map = new HashMap<>();
        if(arr.length %2 != 0) {
            return false;
        }
        for(int i=0; i<arr.length; i++) {
            int rem = arr[i]%k;
            if(map.get(rem) == null) {
                map.put(rem, 1);
            }
            else {
                int count = map.get(rem);
                map.put(rem, count+1);
            }
        }
        for(int i=0; i<arr.length; i++) {
            int rem = arr[i]%k;
            if(k == 2*rem) {
                if(map.get(rem) % 2 != 0) {
                    return false;
                }
            }
            else if(rem == 0) {
                if(map.get(rem) % 2 != 0) {
                    return false;
                }
            }
            else {
               int half = k- rem;
               if(map.get(half) == null || map.get(half) != map.get(rem)) {
                   return false;
               }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 5, 3};
        int k = 6;
        DivideInPairs obj = new DivideInPairs();
        boolean res = obj.CountPairs(arr, k);
        System.out.println(res);
    }
}
