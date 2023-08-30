package Dynamic_Programming;

public class Edit_Distance {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method minDistance：请返回将 word1 转换成 word2 所使用的最少操作数
     * @param String word1, String word2
     * @return 最优操作数
     * @Address https://leetcode.cn/problems/edit-distance/description/
     * @TitleName 72.编辑距离
     */
    public int minDistance(String word1, String word2) {
        //动态规划数组 dp
        //dp[i][j] 表示 第一个字符串 word1 到 i 为止，第二个字符串到 j 为止，变换所需要的最优操作数
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //显然，从长度为 0 的字符串变换到长度为 i 或 j 的字符串需要添加 i 或 j 个字符
        for (int i = 0;i < dp.length;i++)
            dp[i][0] = i;
        for (int j = 0;j < dp[0].length;j++)
            dp[0][j] = j;
        //动态规划
        for (int i = 1;i <= word1.length();i++)
            for (int j = 1;j <= word2.length();j++){
                //当尾部字符相同时，结果即为考虑 i-1 长度的 word1 以及 j-1 长度的 word2
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //否则
                    //考虑三种变换方式
                    //替换：i-1 长度的 word1 变换 j-1 长度的 word2 加上 一次的替换
                    //删除/插入：
                    // i-1 长度的 word1 变换 j 长度的 word2 加上 一次删除
                    // i 长度的 word1 变换 j-1 长度的 word2 加上 一次插入
                    //最终结果为其中的较小值
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1] + 1 , dp[i-1][j] + 1), dp[i][j-1] + 1 );
                }
            }
        return dp[word1.length()][word2.length()];
    }
}
