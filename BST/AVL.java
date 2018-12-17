class AVL {

    private class Node {
        int data;
        Node left;
        Node right;
        int ht;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.ht = 1;
        }
    }

    Node root;

    int height(Node nn) {
        if(nn == null) {
            return 0;
        }
        return nn.ht;
    }

    int getBalance(Node nn) {
        if(nn == null) {
            return 0;
        }
        return (height(nn.left) - height(nn.right));
    }

    Node LeftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        x.ht = java.lang.Math.max(height(x.left), height(x.right)) +1;
        y.ht = java.lang.Math.max(height(y.left), height(y.right)) +1;
        return y;
    }

    Node rightRotate(Node x) {
        Node y = x.left;
        Node t2 = y.right;
        y.right = x;
        x.left = t2;
        x.ht = java.lang.Math.max(height(x.left), height(x.right)) +1;
        y.ht = java.lang.Math.max(height(y.left), height(y.right)) +1;
        return y;
    }

    Node add(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        else if(root.data > data) {
            root.left = add(root.left, data);
        }
        else if(root.data < data) {
            root.right = add(root.right, data);
        }
        else return root;
        root.ht = java.lang.Math.max(height(root.left), height(root.right)) + 1;
        int bal = getBalance(root);
        if(bal > 1) {
            if(getBalance(root.left) > 0) {
                root = rightRotate(root);
            }
            else {
                root.left = LeftRotate(root.left);
                root = rightRotate(root);
            }
        }
        else if(bal < -1) {
            if(getBalance(root.right) < 0) {
                root = LeftRotate(root);
             }
             else {
                 root.right = rightRotate(root.right);
                 root = LeftRotate(root);
             }
        }
        return root;
    }

    void add(int data) {
        root = add(root, data);
    }

    void PreOrder(Node root) {
        if(root == null) {
            return; 
        }
        System.out.println(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void main(String[] args) {
        AVL obj = new AVL();
        obj.root = null;
        obj.add(10);
        obj.add(20);
        obj.add(30);
        obj.add(40);
        obj.add(50);
        obj.add(25);
        obj.PreOrder(obj.root);
    }
}
