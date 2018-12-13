import java.util.Set;
import java.util.HashSet;

class EvenSubSets {

    void FindEvenSeq(int[] arr) {
        Set<Integer>set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] %2 == 0) {
                set.add(arr[i]);
            }
        }
        System.out.println(java.lang.Math.pow(2, set.size()) - 1);
    }

    public static void main(String[] args) {
        EvenSubSets obj = new EvenSubSets();
        int[] arr = new int[]{4, 2, 1, 9, 2, 6, 5, 3};
        obj.FindEvenSeq(arr);
    }

}
