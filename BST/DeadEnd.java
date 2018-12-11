class DeadEnd {

    void FindEnd(BST bst) {
        boolean res = FindEndUtil(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(res);
    }

    boolean FindEndUtil(BST.Node root, int min, int max) {
        if(root == null) {
            return false;
        }
        if(min == max) {
            return true;
        }
        return (FindEndUtil(root.left, min, (Integer)root.data-1) || FindEndUtil(root.right, (Integer)root.data+1, max));
    }

    public static void main(String[] args) {
        DeadEnd obj = new DeadEnd();
        BST<Integer> bst = new BST<>();
        bst.insert(8);
        bst.insert(5);
        bst.insert(2);
        bst.insert(3);
        bst.insert(7);
        bst.insert(11);
        bst.insert(4);
        obj.FindEnd(bst);
    }
}
