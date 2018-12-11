class BstFromPre {

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

    class Index {
        int index;
        Index(int index) {
            this.index = index;
        }
    }

    void create(int[] pre) {
        Index index = new Index(0);
        root = CreateUtil(pre, index, 0, pre.length-1);
    }

    Node CreateUtil(int[] pre, Index index, int l, int r) {
        if(l>r) {
            return null;
        }
        Node root = new Node(pre[index.index]);
        int i;
        for(i=l+1; i<=r; i++) {
            if(pre[i] > pre[index.index]) {
                break;
            }
        }
        (index.index)++;
        root.left = CreateUtil(pre, index, index.index, i-1);
        root.right = CreateUtil(pre, index, i, r);
        return root;
    }

    void Display(Node root) {
        if(root == null) {
            return;
        }
        Display(root.left);
        System.out.print(root.data + " ");
        Display(root.right);
    }

    public static void main(String[] args) {
        BstFromPre obj = new BstFromPre();
        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        obj.create(pre);
        obj.Display(obj.root);
    }
}
