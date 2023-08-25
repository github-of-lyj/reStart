package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method lengthOfLIS：返回最长的递增子序列
     * @param int[] nums：目标数组
     * @return 最长子序列的长度
     * @Address https://leetcode.cn/problems/longest-increasing-subsequence/description/
     * @TitleName 300. 最长递增子序列
     */
    public int lengthOfLIS(int[] nums) {
        //dp[i]表示考虑前 i 个元素，以 nums[i] 元素结尾的最大子序列长度
        int[] dp = new int[nums.length+1];
        dp[1] = 1;
        //dp[i]位置的值为先前已经找到的 dp[1..i-1] 中的最大值加 1
        for (int i = 2;i <= nums.length;i++){
            int dpMax = 0;
            for (int j = i-1;j > 0;j--){
                //前提条件 结尾元素值要大于对应的结尾元素值才能形成更长的子序列
                if (nums[i-1] <= nums[j-1])
                    continue;
                dpMax = Math.max(dpMax,dp[j]);
            }
            dp[i] = dpMax + 1;
        }
        //将数组最大的 dp[i]作为结果返回
        int result = 0;
        for (int oneResult : dp)
            result = Math.max(result,oneResult);
        return result;
    }
}
