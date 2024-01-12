package day5_LinklistBasics;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

public class Solution20 {
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

    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if (head == null || head.next == null) {
            return head;
        }
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}


