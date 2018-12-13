import java.util.Set;
import java.util.HashSet;

class FindSum {

    boolean Sum(int[] arr1, int[] arr2, int[] arr3, int k) {
        Set<Integer>set = new HashSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            for(int j=0; j<arr3.length; j++) {
                int sum = (arr2[i] + arr3[j]);
                if(set.contains(k - sum)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindSum obj = new FindSum();
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{2, 3, 6, 1, 2};
        int[] arr3 = new int[]{3, 2, 4, 5, 6};
        int k = 9;
        boolean res = obj.Sum(arr1, arr2, arr3, k);
        System.out.println(res);
    }
}
