import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MergeSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    void Merge(ArrayList<ListNode>arl) {
        PriorityQueue<ListNode>pq = new PriorityQueue<>(new Comparator<ListNode>(){
    public int compare(ListNode list1, ListNode list2) {
        return ((Integer)list1.val).compareTo((Integer)list2.val);
    }
});
        for(int i=0; i<arl.size(); i++) {
            pq.add(arl.get(i));
        }
        ListNode head = null;
        ListNode tail = head;
        while(pq.size() > 0) {
            ListNode nn = pq.poll();
            if(head == null) {
                head = nn;
                tail = head;
            }
            else {
                tail.next = nn;
                tail = tail.next;
            }
            if(nn.next != null) {
                pq.add(nn.next);
            }
        }
        tail.next = null;
        Display(head);
    }

    void Display(ListNode head) {
        if(head == null) {
            return;
        }
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MergeSortedLists obj = new MergeSortedLists();
        ListNode head1 = obj.new ListNode(30);
        head1.next = obj.new ListNode(40);
        head1.next.next = obj.new ListNode(50);
        ListNode head2 = obj.new ListNode(35);
        head2.next = obj.new ListNode(45);
        ListNode head3 = obj.new ListNode(10);
        head3.next = obj.new ListNode(60);
        head3.next.next = obj.new ListNode(70);
        head3.next.next.next = obj.new ListNode(80);
        head3.next.next.next.next = obj.new ListNode(100);
        ArrayList<ListNode>arl = new ArrayList<>();
        arl.add(head1);
        arl.add(head2);
        arl.add(head3);
        obj.Merge(arl);
    }
}
