import java.util.Set;
import java.util.HashSet;

class ContiguousIntegers {

    void FindContiguousInt(int[] arr) {
        Set<Integer>set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        int count = 1;
        int prev = arr[0]-1;
        while(set.contains(prev) == true) {
            prev--;
            count++;
        }
        int next = arr[0] + 1;
        while(set.contains(next) == true) {
            next++;
            count++;
        }
        if(count == set.size()) {
            System.out.println("Yes");
        }
        else System.out.println("No");
    }

    public static void main(String[] args) {
        ContiguousIntegers obj = new ContiguousIntegers();
        int[] arr = new int[]{5, 2, 3, 6, 4, 4, 6, 6};
        obj.FindContiguousInt(arr);
    }

}
