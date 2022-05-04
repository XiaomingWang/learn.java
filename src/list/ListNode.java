package list;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public void printValues() {
        ListNode cur = this;

        while (cur != null) {
            System.out.printf("%d", cur.val);
            cur = cur.next;
            if (cur != null) System.out.printf(" -> ");
        }
        System.out.printf("\n");

    }

}
