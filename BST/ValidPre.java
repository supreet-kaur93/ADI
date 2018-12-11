class ValidPre {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    void CreateFromPre(int[] arr) {
        Node root = null;
        root = Create(arr, 0, arr.length-1);
        //Print(root);
        boolean x = CheckValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.print(x);
    }

    int index;
    Node Create(int[] arr, int l, int r) {
        if(l>r) {
            return null;
        }
        Node root = new Node(arr[index]);
        int i;
        for(i=l+1; i<=r; i++) {
            if(arr[i] > arr[index]) {
                break;
            }
        }
        index++;
        root.left = Create(arr, index, i-1);
        root.right = Create(arr, i, r);
        return root;
    }

    void Print(Node root) {
        if(root == null) {
            return;
        }
        Print(root.left);
        System.out.println(root.data);
        Print(root.right);
    }

    boolean CheckValid(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.data < min || root.data > max) {
            return false;
        }
        return (CheckValid(root.left, min, root.data-1) && CheckValid(root.right, root.data+1, max));
    }

    public static void main(String[] args) {
        ValidPre obj = new ValidPre();
        int[] arr = new int[]{40, 30, 35, 80, 100};
        obj.CreateFromPre(arr);
    }

}
