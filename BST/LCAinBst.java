import java.util.Comparator;

class LCAinBst {

    void LCA(BST bst) {
        BST.Node lca = LCAUtil(bst.root, 10, 14);
        if(lca == null) {
            return;
        }
        System.out.println(lca.data);
    }

    BST.Node LCAUtil(BST.Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        int cmp1 = ((Integer)root.data).compareTo(n1);
        int cmp2 = ((Integer)root.data).compareTo(n2);
        if(cmp1 == 0 || cmp2 == 0) {
            return root;
        }
        if(cmp1 < 0 && cmp2 < 0) {
            return LCAUtil(root.right, n1, n2);
        }
        else if(cmp1 > 0 && cmp2 > 0) {
            return LCAUtil(root.left, n1, n2);
        }
        return root;
    }

    public static void main(String[] args) {
        LCAinBst obj = new LCAinBst();
        BST<Integer> bst = new BST<>();
        bst.insert(20);
        bst.insert(8);
        bst.insert(22);
        bst.insert(4);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);
        obj.LCA(bst);
    }
}
