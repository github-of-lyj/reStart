package Dynamic_Programming;

public class Two_Keys_Keyboard {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method minSteps：给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数
     * @param int n
     * @return 最少的操作次数
     * @Address https://leetcode.cn/problems/2-keys-keyboard/description/
     * @TitleName 650. 只有两个键的键盘
     */
    public int minSteps(int n) {
        //动态规划数组
        //dp[i]表示延展到长度 i 的最少操作次数
        //n为1时，无需进行操作
        int[] dp = new int[n+1];
        int temp = (int) Math.sqrt(n);
        dp[1] = 0;
        for (int i = 2;i <= n;i++){
            //最坏情况下仅由第一个初始的 ‘A’ 复制而来
            dp[i] = i;
            //对于每个位置j
            //如果 j 可以被 i 整除，那么长度 i 就可以由长度 j 操作得到
            //其操作次数等价于把一个长度为 1的 A 延展到长度为 i/j
            for (int j = 2;j <= temp && j < i;j++)
                if (i % j == 0){
                    dp[i] = dp[j] + dp[i/j];
                    break;
                }
        }
        return dp[n];
    }
}
