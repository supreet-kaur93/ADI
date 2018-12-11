import java.util.ArrayList;
import java.util.Collections;

class BTtoBST {

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

    void convert() {
        ArrayList<Integer>al = new ArrayList<>();
        StoreInArray(root, al);
        Collections.sort(al);
        StoreBack(root, al);
    }

    void StoreInArray(Node root, ArrayList<Integer>al) {
        if(root == null) {
            return;
        }
        StoreInArray(root.left, al);
        al.add(root.data);
        StoreInArray(root.right, al);
    }

    static int x;

    void StoreBack(Node root, ArrayList<Integer>al) {
        if(root == null) {
            return;
        }
        StoreBack(root.left, al);
        root.data = al.get(x);
        x++;
        StoreBack(root.right, al);
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
        BTtoBST obj = new BTtoBST();
        obj.root = obj.new Node(10);
        obj.root.left = obj.new Node(30);
        obj.root.right = obj.new Node(15);
        obj.root.left.left = obj.new Node(20);
        obj.root.right.right = obj.new Node(5);
        obj.convert();
        obj.InOrder(obj.root);
    }
}
