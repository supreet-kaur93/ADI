import java.util.Set;
import java.util.HashSet;

class LongestConsecutive {

    void FindSubSeq(int[] arr) {
        int max = 0;
        Set<Integer>set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            set.add(val);
        }
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(set.contains(val-1) == false) {
                int j = arr[i];
                while(set.contains(j)) {
                    j++;
                }
                if(max < j-arr[i]) {
                    max = j-arr[i];
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        LongestConsecutive obj = new LongestConsecutive();
        int[] arr = new int[]{1, 9, 3, 10, 4, 20, 2};
        obj.FindSubSeq(arr);
    }

}
