import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;

class ReversePathBst {

    void ReversePath(BST obj, int data) {
        Queue<Integer>queue = new LinkedList<Integer>();
        ReversePathUtil(obj.root, queue, data);
        InOrder(obj.root);
    }

    @SuppressWarnings("unchecked")
    void ReversePathUtil(BST.Node root, Queue<Integer>queue, int data) {
        if(root == null) {
            return;
        }
        int cmp = ((Integer)root.data).compareTo(data);
        if(cmp == 0) {
            queue.add((Integer)root.data);
            root.data = queue.peek();
            queue.remove();
            return;
        }
        if(cmp < 0) {
            queue.add((Integer)root.data);
            ReversePathUtil(root.right, queue, data);
            root.data = queue.peek();
            queue.remove();
        }
        else if(cmp > 0) {
            queue.add((Integer)root.data);
            ReversePathUtil(root.left, queue, data);
            root.data = queue.peek();
            queue.remove();
        }
    }

    void InOrder(BST.Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void main(String[] args) {
        ReversePathBst obj = new ReversePathBst();
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        obj.ReversePath(bst, 80);
    }
}
