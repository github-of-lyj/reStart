package Dynamic_Programming;

public class Best_Time_to_Buy_and_Sell_Stock {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method：给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
        你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
        返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * @param：int[] prices
     * @return：最大利润
     * @Address：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
     * @TitleName：121. 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        //初始股票的最低价格以及最大盈利值
        int curMin = prices[0];
        int getMax = 0;
        //遍历过程中改变股票的最小买入价格
        //将最低买入价格减去当前遍历到的卖出价格即为利润
        //所能得到的最大值即为最终结果
        for (int i = 1;i < prices.length;i++){
            if (prices[i] < curMin)
                curMin = prices[i];
            getMax = Math.max(prices[i] - curMin,getMax);
        }
        return getMax;
    }
}
