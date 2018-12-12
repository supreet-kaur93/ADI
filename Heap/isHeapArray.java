class isHeapArray {

    boolean IsHeapUtil(int[] arr, int index, int n) {
        if(index > (n-2)/2) {
            return true;
        }
        if((arr[2*index+1] > arr[index]) && (arr[2*index+2] > arr[index])) {
            return false;
        }
        return (IsHeapUtil(arr, 2*index+1, n) && IsHeapUtil(arr, 2*index+2, n));
    }

    boolean IsHeap(int[] arr) {
        return IsHeapUtil(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {90, 15, 10, 7,12, 2, 7, 3};
        isHeapArray obj = new isHeapArray();
        boolean res = obj.IsHeap(arr);
        System.out.println(res);
    }

}
