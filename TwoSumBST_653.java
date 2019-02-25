package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST_653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public static void main(String[] args) {
        TwoSumBST_653 b = new TwoSumBST_653();
        b.insert(5);
        b.insert(3);
        b.insert(2);
        b.insert(6);
        b.insert(9);
        b.insert(7);
        System.out.print(b.findTarget(root, 9));
    }

    public static TreeNode root;

    private void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent;
        while (true) {
            parent = current;
            if (data < current.val) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }

            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}
