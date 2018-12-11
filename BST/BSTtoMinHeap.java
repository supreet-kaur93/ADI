import java.util.ArrayList;

class BSTtoMinHeap {

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

    void ConvertToMinHeap() {
        ArrayList<Integer>al = new ArrayList<>();
        StoreInArray(root, al);
        StoreInPre(root, al);
    }

    int index;

    void StoreInArray(Node root, ArrayList<Integer>al) {
        if(root == null) {
            return;
        }
        StoreInArray(root.left, al);
        al.add(root.data);
        StoreInArray(root.right, al);
    }
 
    void StoreInPre(Node root, ArrayList<Integer>al) {
        if(root == null) {
            return;
        }
        root.data = al.get(index);
        index++;
        StoreInPre(root.left, al);
        StoreInPre(root.right, al);
    }

    void PreOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void main(String[] args) {
        BSTtoMinHeap obj = new BSTtoMinHeap();
        obj.root = obj.new Node(4);
        obj.root.left = obj.new Node(2);
        obj.root.right = obj.new Node(6);
        obj.root.left.left = obj.new Node(1);
        obj.root.left.right = obj.new Node(3); 
        obj.root.right.left = obj.new Node(5);
        obj.root.right.right = obj.new Node(7);
        obj.ConvertToMinHeap();
        obj.PreOrder(obj.root);
    }
}
