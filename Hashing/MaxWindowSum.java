import java.util.Set;
import java.util.HashSet;

class MaxWindowSum {

    void WindowSum(int[] arr1, int[] arr2) {
        Set<Integer>set = new HashSet<>();
        int sum = 0, begin = 0, max = 0;
        for(int i=0; i<arr1.length; i++) {
            while(set.contains(arr1[i]) == true) {
                set.remove(arr1[begin]);
                sum = sum - arr2[begin];
                begin++;
            }
            sum = sum + arr2[i];
            set.add(arr1[i]);
            if(sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 2, 3, 0, 1, 4};
        int[] arr2 = new int[]{9, 8, 1, 2, 3, 4, 5};
        MaxWindowSum obj = new MaxWindowSum();
        obj.WindowSum(arr1, arr2);
    }
}
