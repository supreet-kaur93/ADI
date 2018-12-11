class ValidBst {

    void IsValid(BST.Node root) {
        if(root == null) {
            return;
        }
        boolean res = IsValidUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(res);
    }

    boolean IsValidUtil(BST.Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if((Integer)root.data < min || (Integer)root.data > max) {
            return false;
        }
        return (IsValidUtil(root.left, min, (Integer)root.data-1) && IsValidUtil(root.right, (Integer)root.data+1, max));
    }

    public static void main(String[] args) {
       ValidBst obj = new ValidBst();
       BST<Integer> bst = new BST<>();
       bst.insert(5);
       bst.insert(4);
       bst.insert(3);
       bst.insert(7);
       obj.IsValid(bst.root);
    }

}
