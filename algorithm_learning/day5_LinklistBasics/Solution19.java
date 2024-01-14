package day5_LinklistBasics;

public class Solution19 {
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

    public ListNode reverseList(ListNode head) {
        ListNode tem;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }
}
