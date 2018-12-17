class GetRank {

    class Node {
        int data;
        Node left;
        Node right;
        int sz;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.sz = 1;
        }
    }

    Node root;

    int size(Node nn) {
        if(nn == null) {
            return 0;
        }
        return nn.sz;
    }

    Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        else if(root.data > data) {
            root.left = insert(root.left, data);
        }
        else if(root.data < data) {
            root.right = insert(root.right, data);
        }
        else return root;
        root.sz = size(root.left) + size(root.right) +1;
        return root;
    }

    int getRank(Node root, int val) {
        if(root == null) {
            return -1;
        }
        if(val < root.data) {
            return getRank(root.left, val);
        }
        else if(val == root.data) {
            return size(root.left);
        }
        int res = getRank(root.right, val);
        if(res != -1) {
            res = res + size(root.left) + 1;
        }
        return res;
    }

    /*int getRank(int val) {
        if(!found)
    }*/

    void insert(int data) {
        root = insert(root, data);
    }

    public static void main(String[] args) {
        GetRank obj = new GetRank();
        obj.root = null;
        obj.insert(5);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(4);
        obj.insert(7);
        obj.insert(6);
        obj.insert(8);
        System.out.println(obj.getRank(obj.root, 5));
        System.out.println(obj.getRank(obj.root, 1));
        System.out.println(obj.getRank(obj.root, 9));
        System.out.println(obj.getRank(obj.root, 0));
    }
}
