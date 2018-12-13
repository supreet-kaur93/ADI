import java.util.Map;
import java.util.HashMap;

class FourEleSum {

    private class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    void FindSum(int[] arr) {
        Map<Integer, Pair>map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int sum = arr[i] + arr[j];
                if(map.get(sum) != null) {
                    Pair pair = map.get(sum);
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[pair.i] + " " + arr[pair.j]);
                    return;
                }
                else {
                    Pair pair = new Pair(i, j);
                    map.put(sum, pair);
                }
            }
        }
    }

    public static void main(String[] args) {
        FourEleSum obj = new FourEleSum();
        int[] arr = new int[]{3, 4, 7, 1, 2, 9, 8};
        obj.FindSum(arr);
    }
}
