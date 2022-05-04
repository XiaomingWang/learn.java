package list;

import java.util.Stack;


/**
 *  Given the head of a singly linked list, reverse the list, and return the reversed list.
 *  Examples:
 *      Input: head = [1,2,3,4,5]
 *      Output: [5,4,3,2,1]
 *
 * @author Xiaoming Wang
 */
public class ReverseList {


    /**
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * 1->2->3->null reverse to null <- 1 <- 2 <- 3
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cursor = head;
        ListNode next = null;

        while (cursor != null) {
            next = cursor.next;

            cursor.next = prev;
            prev = cursor;

            cursor = next;
        }

        return prev;
    }

    /**
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param head
     * @return
     */
    public static ListNode reverseList_1(ListNode head) {
        if (head == null) return null;

        Stack<Integer> stack = new Stack<>();
        ListNode cursor = head;
        while (cursor != null) {
            stack.push(cursor.val);
            cursor = cursor.next;
        }

        cursor = head;
        while (!stack.isEmpty() && cursor != null) {
            cursor.val = stack.pop();
            cursor = cursor.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3,
                new ListNode(5,
                        new ListNode(7,
                                new ListNode(-1,
                                        new ListNode(8, null)))));
        node.printValues();

        node = reverseList(node);

        node.printValues();
    }


}
