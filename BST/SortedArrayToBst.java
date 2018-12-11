class SortedArrayToBst {

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

    void store(int[] arr) {
        Node root = CreateBst(arr, 0, arr.length-1);
        InOrder(root);
    }

    Node CreateBst(int[] arr, int l, int r) {
        if(l>r) {
            return null;
        }
        int mid = (l+r)/2;
        Node root = new Node(arr[mid]);
        root.left = CreateBst(arr, l, mid-1);
        root.right = CreateBst(arr, mid+1, r);
        return root;
   }

    void InOrder(Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }

    public static void main(String[] args) {
        SortedArrayToBst obj = new SortedArrayToBst();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        obj.store(arr);
    }
}
