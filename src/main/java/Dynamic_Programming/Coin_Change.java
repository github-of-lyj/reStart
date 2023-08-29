package Dynamic_Programming;

import java.util.Arrays;

public class Coin_Change {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method coinChange；给定一些硬币的面额，求最少可以用多少颗硬币组成给定的金额
     * @param coins：硬币面额数组  amount：目标金额
     * @return  存在则返回对应的银币数，不存在则返回 -1
     * @Address https://leetcode.cn/problems/coin-change/submissions/
     * @TitleName 322. 零钱兑换
     */
    public int coinChange(int[] coins, int amount) {
        //动态规划
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0;i < dp.length;i++)
            dp[i][0] = 0;
        //一定不存在的情况初始化为 amount + 1
        //因为使用硬币最多的情况是 1 元硬币，使用硬币数维 amount
        for (int i = 1;i < dp[0].length;i++)
            dp[0][i] = amount+1;
        //如果当前考虑的金额大于等于当前硬币面额
        //最终值是二者当中较小的一个
        for (int i = 1;i < dp.length;i++)
            for (int j = 1;j < dp[0].length;j++){
                if (coins[i-1] <= j)
                    //考虑前 i-1 枚硬币的情况 和 投入一枚当前硬币的情况
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]] + 1);
                else
                    dp[i][j] = dp[i-1][j];
            }
        //返回最终结果
        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
    }
}
