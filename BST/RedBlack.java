class RedBlack {

    boolean RED = true;
    boolean BLACK = false;

    private class Node {
        int data;
        Node left;
        Node right;
        boolean color;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    Node root;

    boolean color(Node x) {
        if(x == null) {
            return BLACK;
        }
        return x.color;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        if(y != null)
        y.color = x.color;
        if(x != null)
        x.color = RED;
        return y;
    }

    Node rightRotate(Node x) {
        Node y = x.left;
        Node t2 = y.right;
        y.right = x;
        x.left = t2;
        if(y != null)
        y.color = x.color;
        if(x != null)
        x.color = RED;
        return y;
    }

    Node swapColors(Node x) {
        if(x.left != null)
            x.left.color = x.color;
        if(x.right != null)
            x.right.color = x.color;
        x.color = RED;
        return x;
    }

    Node Insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(root.data > data) {
            root.left = Insert(root.left, data);
        }
        else if(root.data < data) {
            root.right = Insert(root.right, data);
        }
        else return root;
        if(color(root.left) == BLACK && color(root.right) == RED) {
            root = leftRotate(root);
        }
        if(color(root.left) == RED && color(root.left.left) == RED) {
            root = rightRotate(root);
        }
        if(color(root.left) == RED && color(root.right) == RED) {
           root = swapColors(root);
        }
        return root;
    }

    void Insert(int data) {
        root = Insert(root, data);
    }

    void PreOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void main(String[] args) {
        RedBlack obj = new RedBlack();
        obj.root = null;
        obj.Insert(10);
        obj.Insert(20);
        obj.Insert(30);
        obj.Insert(40);
        obj.Insert(50);
        obj.Insert(25);
        obj.PreOrder(obj.root);
    }
}
