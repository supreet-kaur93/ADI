import java.util.Map;
import java.util.HashMap;

class GivenSumArray {

    void FindSum(int[] arr, int k) {
        int sum = 0;
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
            if(sum == k) {
                System.out.println("0 to " + i);
                return;
            }
            if(map.get(sum - k) != null) {
                System.out.println(map.get(sum - k)+1 + " to " + i);
                return;
            }
            map.put(sum, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 20, 3, 10, 5};
        GivenSumArray obj = new GivenSumArray();
        int k = 33;
        obj.FindSum(arr, k);
    }

}
