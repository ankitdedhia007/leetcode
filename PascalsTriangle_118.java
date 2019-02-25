package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_118 {
    public Integer[][] generate(int numRows) {
        Integer[] tmppArr;
        Integer[][] finalArr = new Integer[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            tmppArr = new Integer[i + 1];
            tmppArr[0] = 1;
            for (int j = 1; j <= i - 1; j++) {
                tmppArr[j] = finalArr[i - 1][j - 1] + finalArr[i - 1][j];
            }
            tmppArr[tmppArr.length - 1] = 1;
            finalArr[i] = tmppArr;
        }
        return finalArr;
    }

    private List<List<Integer>> generateList(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>(numRows);
        Integer[] tmppArr;
        for (int i = 0; i < numRows; i++) {
            tmppArr = new Integer[i + 1];
            tmppArr[0] = 1;
            for (int j = 1; j <= i - 1; j++) {
                tmppArr[j] = returnList.get(i - 1).get(j - 1) + returnList.get(i - 1).get(j);
            }
            tmppArr[tmppArr.length - 1] = 1;
            returnList.add(Arrays.asList(tmppArr));
        }

        return returnList;
    }

    public static void main(String[] args) {
        PascalsTriangle_118 p = new PascalsTriangle_118();
        for (Integer[] ret : p.generate(5)) {
            for (int i : ret) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println(p.generateList(5));
    }
}