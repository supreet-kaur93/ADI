class MinHeap {

    int[] arr;
    int sz;
    int size;

    MinHeap(int sz) {
        this.sz = sz;
        this.size = 0;
        arr = new int[this.sz];
    }

    void excn(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void insert(int data) {
        size++;
        arr[size] = data;
        swim(size);
    }

    void swim(int index) {
        while(index > 0 && arr[index] < arr[index/2]) {
            excn(index, index/2);
            index = index/2;
        }
    }

    int delMin() {
        int val = arr[1];
        excn(1, size--);
        sink(1);
        return val;
    }

    void sink(int index) {
        while(2*index < size) {
            int j = 2*index;
            if(arr[j] > arr[j+1]) j++;
            if(arr[j] > arr[index]) break;
            excn(j, index);
            index = j;
        }
    }

    public static void main(String[] args) {
        MinHeap obj = new MinHeap(6);
        for(int i=5; i>0; i--) {
            obj.insert(i);
        }
        for(int i=0; i<5; i++) {
            System.out.print(obj.delMin() + " ");
        }
    }
}
