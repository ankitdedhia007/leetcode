package com.leetcode;

public class LinkedListCycle_141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode n1 = head;
        ListNode n2 = head;
        while (n1 != null && n2 != null) {
            n1 = n1.next;
            if (n1 == null) return false;
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == n2)   return true;
        }
        return false;
    }
}
