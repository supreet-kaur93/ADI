import java.util.Comparator;

class ShortestDistance {

    void ShortestDis(BST bst) {
        int res = ShortestDisUtil(bst.root, 5, 35);
        System.out.println(res);
    }

    int ShortestDisUtil(BST.Node root, int n1, int n2) {
        if(root == null) {
            return 0;
        }
        int cmp1 = ((Integer)root.data).compareTo(n1);
        int cmp2 = ((Integer)root.data).compareTo(n2);
        if(cmp1 < 0 && cmp2 < 0) {
            return 1 + ShortestDisUtil(root.right, n1, n2);
        }
        else if(cmp1 > 0 && cmp2 > 0) {
            return 1 + ShortestDisUtil(root.left, n1, n2);
        }
        return FindDis(root, n1) + FindDis(root, n2);
    }

    int FindDis(BST.Node root, int val) {
        if(root == null) {
            return 0;
        }
        int cmp = ((Integer)root.data).compareTo(val);
        if(cmp == 0) {
            System.out.println("fghjkk ");
            return 0;
        }
        if(cmp < 0) {
            return 1 + FindDis(root.right, val);
        }
        return 1 + FindDis(root.left, val);
    }

    public static void main(String[] args) {
        ShortestDistance obj = new ShortestDistance();
        BST<Integer> bst = new BST<>();
        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(35);
        obj.ShortestDis(bst);
    }

}
