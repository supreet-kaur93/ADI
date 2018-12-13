import java.util.Map;
import java.util.HashMap;

class ZeroSumSubArray {

    void ZeroSum(int[] arr) {
        int sum = 0, max = 0;
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
            if(arr[i] == 0) {
                if(max < 1) {
                    max = 1;
                }
            }
            if(sum == 0) {
                max = i+1;
            }
            if(map.get(sum) != null) {
                if(i - map.get(sum) > max) {
                    max = i-map.get(sum);
                }
            }
            else {
                map.put(sum, i);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, -2, 2, -8, 1, 7, 10, 23};
        ZeroSumSubArray obj = new ZeroSumSubArray();
        obj.ZeroSum(arr);
    }

}
