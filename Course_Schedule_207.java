package com.leetcode;

import java.util.Stack;

public class Course_Schedule_207 {

    public static void main(String[] args) {
        Course_Schedule_207 out = new Course_Schedule_207();
        Solution s = out.new Solution();

      //  System.out.println(s.canFinish(2, new int[][]{{1, 0}}));

        System.out.println(s.canFinish(3, new int[][]{{1, 0}, {2, 0}}));

      //  System.out.println(s.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    public class Solution {
        boolean[] marked;
        boolean[] onstack;
        Stack<Integer> reversePost;
        boolean result = true;
        private boolean canFinish(int numCourses, int[][] prerequisites) {

            if (prerequisites == null || prerequisites.length < 2) {
                return true;
            }
            marked = new boolean[numCourses];
            onstack = new boolean[numCourses];
            reversePost = new Stack<>();
            for (int v = 0; v < numCourses; v++) {
                if(!result) {
                    return false;
                }
                if(!marked[v]) {
                    dfs(v, prerequisites);
                }
            }
            return result;
        }

        private void dfs(int v, int[][] prerequisites) {
            marked[v] = true;
            onstack[v] = true;

            for(int[] arry :prerequisites) {
                if(arry[1] == v) {
                    if(!marked[arry[0]]) {
                        dfs(arry[0], prerequisites);
                    }
                    if(onstack[0]) {
                        result = false;
                    }
                }
            }

            onstack[v] = false;
            reversePost.push(v);
        }
    }
}