package day6_Linklist;

import day5_LinklistBasics.Solution17;
import day5_LinklistBasics.Solution19;

/**
*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Solution21 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode listNode) {
            this.val = val;
            this.next = listNode;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }

}
