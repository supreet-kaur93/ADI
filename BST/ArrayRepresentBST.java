class ArrayRepresentBST {

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

    void CreateTree(int[] arr) {
        Node root = null;
        root = new Node(arr[0]);
        Node temp = root;
        for(int i=1; i<arr.length; i++) {
            if(temp.data < arr[i]) {
                temp.right = new Node(arr[i]);
                temp = temp.right;
            }
            else {
                temp.left = new Node(arr[i]);
                temp = temp.left;
            }
        }
        boolean res = ValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(res);
    }

    boolean ValidBst(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.data < min || root.data > max) {
            return false;
        }
        return (ValidBst(root.left, min, root.data -1) && ValidBst(root.right, root.data+1, max));
    }

    public static void main(String[] args) {
        ArrayRepresentBST obj = new ArrayRepresentBST();
        int[] arr = new int[]{500, 200, 90, 250, 100};
        obj.CreateTree(arr);
        int[] arr1 = new int[]{5123, 3300, 783, 1111, 890};
        obj.CreateTree(arr1);
    }
}
