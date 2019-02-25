package com.leetcode;

public class MinStack_155 {

    class Node {
        Node next;
        int min;
        int val;

        Node(int val, Node next) {
            this.next = next;
            this.val = val;
        }
    }

    Node top;

    /**
     * initialize your data structure here.
     */
    public void push(int x) {
        if (top == null) {
            top = new Node(x, null);
            top.min = x;
            return;
        }

        Node tmpNode = top;
        top = new Node(x, tmpNode);
        if (x <= tmpNode.min) {
            top.min = x;
        } else {
            top.min = tmpNode.min;
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.getMin());   //--> Returns -3.
    }
}