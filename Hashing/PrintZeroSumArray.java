import java.util.Map;
import java.util.HashMap;

class PrintZeroSumArray {

    void FindZeroSum(int[] arr) {
        Map<Integer, Integer>map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
            if(arr[i] == 0) {
                System.out.println("Fount at index " + i);
            }
            if(sum == 0) {
                System.out.println("Fround From 0 to" + i);
            }
            if(map.get(sum) != null) {
                System.out.println("Found from " + (Integer)(map.get(sum)+1) + " to " + i);
            }
            map.put(sum, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3 ,-1 ,-3 ,4 ,-2 ,2 ,4 ,6 ,-12 , -7};
        PrintZeroSumArray obj = new PrintZeroSumArray();
        obj.FindZeroSum(arr);
    }

}
