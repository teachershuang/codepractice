package day6_Linklist;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * <p>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class Solution22 {
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

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode dummyA = new ListNode(-1, headA);
            ListNode dummyB = new ListNode(-1, headB);
            ListNode curA = dummyA;
            ListNode curB = dummyB;
            int lenA = 0;
            int lenB = 0;
            while (curA.next != null) {
                lenA++;
                curA = curA.next;
            }
            while (curB.next != null) {
                lenB++;
                curB = curB.next;
            }
            curA = headA;
            curB = headB;
            if (lenB > lenA){
                curA = headB;
                curB = headA;
                int tep = lenA;
                lenA = lenB;
                lenB = tep;
            }
            int gap = lenA - lenB;
            while (gap > 0){
                curA = curA.next;
                gap--;
            }
            while (curA != null){
                if (curA == curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }

    }
}
