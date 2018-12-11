import java.util.Comparator;

class Floor {

    void LessThanNo(BST bst) {
        BST.Node floor = LessThanNo(bst.root, 4);
        if(floor == null) {
            return;
        }
        System.out.println(floor.data);
    }

    BST.Node LessThanNo(BST.Node root, int val) {
        if(root == null) {
            return null;
        }
        int cmp = ((Integer)root.data).compareTo(val);
        if(cmp > 0) {
            return LessThanNo(root.left, val);
        }
        BST.Node canBe = root;
        BST.Node rr = LessThanNo(root.right, val);
        if(rr == null) {
            return canBe;
        }
        return rr;
    }

    public static void main(String[] args) {
        Floor obj = new Floor();
        BST<Integer> bst = new BST<>();
        bst.insert(25);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(12);
        bst.insert(9);
        bst.insert(21);
        bst.insert(19);
        bst.insert(25);
        obj.LessThanNo(bst);
    }
}
