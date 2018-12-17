class HeapSort {

    int[] arr;
    int index;
    HeapSort(int size) {
        arr = new int[size];
    }

    void insert(int val) {
        index++;
        arr[index] = val;
        swim(index);
    }

    void swim(int index) {
        while(index>1 && arr[index] > arr[index/2]) {
            swap(index, index/2);
            index = index/2;
        }
    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void sink(int i, int index) {
        while(2*i < index) {
            int j = 2*i;
            if(arr[j] < arr[j+1]) j++;
            if(arr[j] < arr[i]) break;
            swap(j, i);
            i = j;
        }
    }

    void deleteMax(int i) {
        swap(1, i);
	sink(1, i-1);
    }

    void Sort() {
        for(int i=index; i>0; i--) {
            deleteMax(i);
        }
    }

    void display() {
        for(int i=1; i<=index; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort(6);
        obj.insert(1);
        obj.insert(3);
        obj.insert(2);
        obj.insert(5);
        obj.insert(4);
        obj.Sort();
        obj.display();
    }
}
