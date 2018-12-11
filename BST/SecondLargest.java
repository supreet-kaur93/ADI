class SecondLargest {

    int SecLar;
    int index;
    void FindSecondLargest(BST.Node root) {
        if(root == null) {
            return;
        }
        FindSecondLargest(root.right);
        index++;
        if(index == 2) {
            SecLar = (Integer)root.data;
        }
        FindSecondLargest(root.left);
    }

    public static void main(String[] args) {
        SecondLargest obj = new SecondLargest();
        BST<Integer> bst = new BST<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(8);
        obj.FindSecondLargest(bst.root);
        System.out.println(obj.SecLar);
    }
}
