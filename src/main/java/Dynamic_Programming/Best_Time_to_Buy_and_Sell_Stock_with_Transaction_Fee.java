package Dynamic_Programming;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        //buy[i] 表示第 i 天交易完成手中持有股票的最大收益
        //sell[i] 表示第 i 天交易完成没有股票的最大收益
        //s1[i] 表示第 i 天选择不卖出股票的额最大收益（buy 到 sell 的中间状态）
        //s2[i] 表示第 i 天选择不买入股票的最大收益（sell 到 buy 的中间状态）
        int[] buy = new int[prices.length + 1];
        int[] s1  = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        int[] s2  = new int[prices.length + 1];
        //第 1 天持有股票最大收益即为股票的价格
        buy[1] = s1[1] = -prices[0];
        //第 1 天不持有股票的最大收益为 0
        sell[1] = s2[1] = 0;
        //根据状态图进行状态转移
        for (int i = 2;i <= prices.length;i++){
            buy[i] = Math.max(sell[i-1] - prices[i-1], s2[i-1] - prices[i-1]);
            s1[i] = Math.max(s1[i-1] , buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i-1] - fee, s1[i-1] + prices[i-1] - fee);
            s2[i] = Math.max(s2[i-1] , sell[i-1]);
        }
        //最终结果即为二者之中的较大值
        return Math.max(sell[prices.length],s2[prices.length]);
    }
}
