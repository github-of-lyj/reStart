package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Common_Subsequence {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method longestCommonSubsequence：返回两个不同字符串中的最短公共子序列长度
     * @param String text1, String text2
     * @return 最短子序列长度
     * @Address https://leetcode.cn/problems/longest-common-subsequence/description/
     * @TitleName 1143. 最长公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]表示考虑第一个字符串到 i 为止 ，第二个字符串到 j 为止的最短公共子序列长度
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //dp[i-1][j-1] 的值与 dp[i][j] 的值之间至多相差 1  当且仅当 text1 中 i 位置的字符 和 text2 中 j 位置的字符相等时
        //若不相等，则 dp[i][j] 为 dp[i-1][j] 和 dp[i][j-1] 中的较大值
        for (int i = 1;i <= text1.length();i++)
            for (int j = 1;j <= text2.length();j++){
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        //返回最终结果
        return dp[text1.length()][text2.length()];
    }
}
