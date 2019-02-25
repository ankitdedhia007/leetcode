package com.leetcode;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 b = new BestTimeToBuyAndSellStock_121();
        System.out.println(b.maxProfit(new int[]{2, 4, 1}));
    }
}