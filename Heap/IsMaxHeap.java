// check if binaryy tree is min heap

class IsMaxHeap {

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

    int CountNodes(Node root) {
        if(root == null) {
            return 0; 
        }
        return 1 + CountNodes(root.left) + CountNodes(root.right);
    }

    boolean IsComplete(Node root, int index, int Nodes) {
        if(root == null) {
            return true;
        }
        if(index >= Nodes) {
            return false;
        }
        return (IsComplete(root.left, 2*index+1, Nodes) && IsComplete(root.right, 2*index+2, Nodes));
    }

    boolean IsMax(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.right == null) {
            if(root.data >= root.left.data) {
                return true;
            }
            return false;
        }
        if(root.data >= root.left.data && root.data >= root.right.data) {
            return (IsMax(root.left) && IsMax(root.right));
        }
        return false;
    }

    void MaxHeap() {
        int nodes = CountNodes(root);
        boolean res = (IsComplete(root, 0, nodes) && IsMax(root));
        System.out.println(res);
    }

    public static void main(String[] args) {
        IsMaxHeap obj = new IsMaxHeap();
        obj.root = obj.new Node(5);
        obj.root.left = obj.new Node(3);
        obj.root.right = obj.new Node(7);
        obj.root.left.left = obj.new Node(1);
        obj.root.left.right = obj.new Node(4);
        obj.root.right.left = obj.new Node(6);
        obj.MaxHeap();
    }
}
