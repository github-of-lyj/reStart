package Dynamic_Programming;

import java.util.Arrays;

public class Perfect_Squares {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method numSquares：返回 和为 n 的完全平方数的最少数量
     * @param int n
     * @return 对应 n 的结果数量
     * @Address https://leetcode.cn/problems/perfect-squares/description/
     * @TitleName 279. 完全平方数
     */
    public int numSquares(int n) {
        //数组初始化
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
//        dp[i] 表示数字 i 最少可以由几个完全平方数相加构成。
//        在本题中，位置 i 只依赖 i - k^2 的位置，
//        如 i - 1、i - 4、i - 9 等等，才能满足完全平方分割的条件
        for (int i = 1;i < dp.length;i++)
            for (int j = 1;j * j <= i;j++)
                dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
        return dp[n];
    }
}
