class TransformBstSumTree {

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

    void TransformToSumTree(Node root) {
        if(root == null) {
            return;
        }
        //sum = sum+root.data;
        TransformToSumTree(root.right);
        sum = sum+root.data;
        root.data = sum - root.data;
        TransformToSumTree(root.left);
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
        TransformBstSumTree obj = new TransformBstSumTree();
        obj.root = obj.new Node(11); 
        obj.root.left = obj.new Node(2); 
        obj.root.right = obj.new Node(29); 
        obj.root.left.left = obj.new Node(1); 
        obj.root.left.right = obj.new Node(7); 
        obj.root.right.left = obj.new Node(15); 
        obj.root.right.right = obj.new Node(40); 
        obj.root.right.right.left = obj.new Node(35); 
        obj.TransformToSumTree(obj.root);
        obj.InOrder(obj.root);
    }
}
