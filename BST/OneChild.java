class OneChild {

    boolean OneChild(BST.Node root) {
        if(root == null) {
            return true;
        }
        if(root.left != null && root.right != null) {
            return false;
        }
        return (OneChild(root.left) && OneChild(root.right));
    }

    public static void main(String[] args) {
        OneChild obj = new OneChild();
        BST bst = new BST();
        bst.insert(8);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(6);
        boolean res = obj.OneChild(bst.root);
        System.out.println(res);
    }
}
