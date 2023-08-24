package Dynamic_Programming;

import java.util.List;

public class Word_Break {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method wordBreak：给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s
     * @param (String s：字符串  List<String> wordDict；字符串列表字典
     * @return true or false
     * @Address https://leetcode.cn/problems/word-break/description/
     * @TitleName 139. 单词拆分
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //动态规划数组
        //dp[i]表示考虑前 i 个字符是否可以由 wordDict 中的字符串组成
        boolean[] dp = new boolean[s.length()+1];
        //初始化 dp[0] = true
        dp[0] = true;
        //从前 1 个字符开始开始考虑
        //如果此时考虑的总字符长度大于等于字典 wordDict 中的某一字符串长度
        //将字符 s 用 substring 方法进行切割得到对应长度的待比较字符串
        //若与 str 相等，将 dp[i] 赋值为 dp[i] || dp[i-str.length()]
        for (int i = 1;i < dp.length;i++)
            for (String str : wordDict) {
                if (i >= str.length() && s.substring(i - str.length(), i).equals(str))
                    dp[i] = dp[i] || dp[i-str.length()];
            }
        //dp[s.length()]即为最终结果
        return dp[s.length()];
    }
}
