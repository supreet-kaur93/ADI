class BstToBt {

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

    Node root;
    int sum;
    void Convert(Node root) {
        if(root == null) {
            return;
        }
        Convert(root.right);
        sum = sum + root.data;
        root.data = sum;
        Convert(root.left);
    }

    void InOrder(Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void main(String[] args) {
        BstToBt obj = new BstToBt();
        obj.root = obj.new Node(5);
        obj.root.left = obj.new Node(2);
        obj.root.right = obj.new Node(13);
        obj.Convert(obj.root);
        obj.InOrder(obj.root);
    }

}
