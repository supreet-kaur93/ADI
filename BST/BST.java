import java.util.Comparator;

class BST<k extends Comparable<k>> {

    class Node<k>{
        k data;
        Node left;
        Node right;
        Node(k data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    void insert(k data) {
        root = insert(root, data);
    }

    Node insert(Node root, k data) {
        if(root == null) {
            return new Node<k> (data);
        }

        @SuppressWarnings("unchecked")
        int cmp = data.compareTo((k)root.data);
        if(cmp > 0) {
            root.right = insert(root.right, data);
        }
        else if(cmp < 0) {
            root.left = insert(root.left, data);
        }
        else {
            return root;
        }
        return root;
    }

    void display(Node root) {
        if(root == null) {
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
}
