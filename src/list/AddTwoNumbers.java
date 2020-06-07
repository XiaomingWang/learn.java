package list;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cursor = dummyHead;
        int carrier = 0;
        while(p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int val = (x + y + carrier) % 10;
            carrier = (x + y + carrier) / 10;

            cursor.next = new ListNode(val);
            cursor = cursor.next;

            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }

        if(carrier > 0) {
            cursor.next = new ListNode(carrier);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(7);
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + (result.next == null ? "" : " -> "));
            result = result.next;
        }
    }

}
