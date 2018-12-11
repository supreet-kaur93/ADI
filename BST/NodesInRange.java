class NodesInRange {

    void PrintInRange(BST.Node root, int min, int max) {
        if(root == null) {
            return;
        }
        PrintInRange(root.left, min, max);
        PrintInRange(root.right, min, max);
        if((Integer)root.data >= min && (Integer)root.data <= max) {
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
         NodesInRange obj = new NodesInRange();
         BST<Integer> bst = new BST<>();
         bst.insert(5);
         bst.insert(2);
         bst.insert(1);
         bst.insert(4);
         bst.insert(7);
         bst.insert(6);
         bst.insert(8);
         obj.PrintInRange(bst.root, 2, 7);
    }

}
