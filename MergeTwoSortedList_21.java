package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoSortedList_21 {
    ListNode head;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode lr = null;
        if(l1 == null && l2 == null) {
            return lr;
        }
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l2 == null && l1 != null) {
            return l1;
        }
        if(l1.next == null && l2.next == null) {
            if (l1.val < l2.val) {
                lr = append(l1.val, lr);
                lr = append(l2.val, lr);
            } else {
                lr = append(l2.val, lr);
                lr = append(l1.val, lr);
            }
            return lr;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lr = append(l1.val, lr);
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                lr = append(l2.val, lr);
                l2 = l2.next;
            } else {
                lr = append(l1.val, lr);
                lr = append(l2.val, lr);
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        while(l1 != null) {
           lr = append(l1.val, lr);
           l1 = l1.next;
        }
        while(l2 != null) {
            lr = append(l2.val, lr);
            l2 = l2.next;
        }
        return lr;
    }

    public ListNode append(int new_data, ListNode lr) {
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        ListNode new_node = new ListNode(new_data);

    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (lr == null) {
            lr = new ListNode(new_data);
            return lr;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        ListNode last = lr;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return lr;
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    private static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = new MergeTwoSortedList_21().stringToListNode(line);
            line = in.readLine();
            ListNode l2 = new MergeTwoSortedList_21().stringToListNode(line);

            ListNode ret = new MergeTwoSortedList_21().mergeTwoLists(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}