class MinValueNode {

    int FindMin(BST.Node root) {
        BST.Node temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }
        return (Integer)temp.data;
    }

    public static void main(String[] args) {
        MinValueNode obj = new MinValueNode();
        BST<Integer> bst = new BST<>();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(5);
        int res = obj.FindMin(bst.root);
        System.out.println(res);
    }
}
