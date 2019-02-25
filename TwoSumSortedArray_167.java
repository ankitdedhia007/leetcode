package com.leetcode;

public class TwoSumSortedArray_167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSumSortedArray_167 sum = new TwoSumSortedArray_167();
        int[] result = sum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.print("[" + result[0] + "," + result[1] + "]");
    }
}