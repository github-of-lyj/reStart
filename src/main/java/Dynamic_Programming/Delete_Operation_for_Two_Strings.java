package Dynamic_Programming;
public class Delete_Operation_for_Two_Strings {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method minDistance：
     * 给定两个单词 word1 和 word2
     * 返回使得 word1 和 word2 相同所需的最小步数。
     * 每步可以删除任意一个字符串中的一个字符。
     * @param：String word1, String word2
     * @return：符合题意的最小步数
     * @Address：https://leetcode.cn/problems/delete-operation-for-two-strings/description/
     * @TitleName：583. 两个字符串的删除操作
     */
    public int minDistance(String word1, String word2) {
        //动态规划数组
        //dp[i][j]表示将 word1 的前 i 个字符变换为 word2 的前 j 个字符所需要进行的最少步骤
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //初始化操作
        //考虑将 i 个 字符变化为 0 个字符的情况，显然只能进行 i 次删除操作
        for (int i = 0;i <= word2.length();i++)
            dp[0][i] = i;
        for (int i = 0;i <= word1.length();i++)
            dp[i][0] = i;
        //动态规划求解
        for (int i = 1;i <= word1.length();i++)
            for (int j = 1;j <= word2.length();j++){
                //软食当前变化字符串的末尾字符相同，则所求结果即为 长度为 i-1 的 word1 变化为长度为 j-1 的 word2
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    //否则会出现两种状况
                    //结果值为 长度为 i-1 的 word1 变化为长度为 j 的 word2 + 1
                    //或      长度为  i  的 word1 变化为长度为 j-1 的 word2 + 1
                    //二者之中取最小值
                    dp[i][j] = Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1);
            }
        //返回 word1 变化为 word2 的最终结果
        return dp[word1.length()][word2.length()];
    }
}
