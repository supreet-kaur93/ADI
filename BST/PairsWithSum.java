import java.util.Stack;

class PairsWithSum {

    void FindPairs(BST bst1, BST bst2, int val) {
        BST.Node root1 = bst1.root;
        BST.Node root2 = bst2.root;
        Stack<BST.Node> stack1 = new Stack<>();
        Stack<BST.Node> stack2 = new Stack<>();
        int count = 0;
        int sum = 0;
        while(true) {
            while(root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null) {
                stack2.push(root2);
                root2 = root2.right;
            }
            if(stack1.empty() || stack2.empty()) {
                break;
            }
            BST.Node curr1 = stack1.peek();
            BST.Node curr2 = stack2.peek();
            sum = (Integer)curr1.data + (Integer)curr2.data;
            if(sum == val) {
                count++;
                root1 = curr1.right;
                root2 = curr2.left;
                stack1.pop();
                stack2.pop();
            }
            else if(sum > val) {
                root2 = curr2.left;
                stack2.pop();
            }
            else {
                root1 = curr1.right;
                stack1.pop();
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        PairsWithSum obj = new PairsWithSum();
        BST<Integer> bst1 = new BST<>();
        bst1.insert(5);
        bst1.insert(3);
        bst1.insert(7);
        bst1.insert(2);
        bst1.insert(4);
        bst1.insert(6);
        bst1.insert(8);

        BST<Integer> bst2 = new BST<>();
        bst2.insert(10);
        bst2.insert(6);
        bst2.insert(15);
        bst2.insert(3);
        bst2.insert(8);
        bst2.insert(11);
        bst2.insert(18);
        int sum = 16;
        obj.FindPairs(bst1, bst2, sum);
    }

}
