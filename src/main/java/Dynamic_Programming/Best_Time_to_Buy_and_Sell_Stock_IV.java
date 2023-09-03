package Dynamic_Programming;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_IV {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method maxProfit：给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
     * @param int k, int[] prices
     * @return 最大利润
     * @Address https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
     * @TitleName 188. 买卖股票的最佳时机 IV
     */
    public int maxProfit(int k, int[] prices) {
        //股市存在的天数
        int length = prices.length;
        if (length < 2)
            return 0;
        //若可交易的次数大于相应的天数
        //则只要存在能获利的情况就将股票卖出
        if (k >= length)
            return CasualMaxProfit(prices);
        //buy[i]数组表示第 i 次买入股票时候所能够获得的最大收益
        //sell[i]数组表示第 i 次售出股票时候所能够获得的最大收益
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy,Integer.MIN_VALUE);
        //对于每天的股票的价格
        for (int price : prices)
            for (int j = 1; j <= k; j++) {
                //第 j 次的最大买入收益就等于 第 j-1 次的最大售出收益减去当前的售出价格 与 第 j 次的最大的买入价格之间的最大值
                //第 j 次的最大售出收益就等于 第 j 次的最大买入收益减去当前的买入价格 与 第 j 次的最大的售出价格之间的最大值
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        return sell[k];
    }

    int CasualMaxProfit(int[] prices){
        int maxProfit = 0;
        for (int i = 1;i < prices.length;i++)
            if (prices[i] > prices[i-1])
                maxProfit+=prices[i];
        return maxProfit;
    }
}
