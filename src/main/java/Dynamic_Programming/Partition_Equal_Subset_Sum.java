package Dynamic_Programming;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method canPartition：判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * @param int[] nums：待分割数组
     * @return true or false
     * @Address https://leetcode.cn/problems/partition-equal-subset-sum/description/
     * @TitleName 416. 分割等和子集
     */
    public boolean canPartition(int[] nums) {
        //若能分割成两个元素和相等的子集
        //则子集的元素和为所有元素和的一半
        int sum = 0;
        for (int i : nums) {
            sum+=i;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum/2;
        //转化为选取元素使得总和为 target
        //dp[i][j] 表示考虑前 i 个数，结果为 j 时的可行情况
        boolean[][] dp = new boolean[nums.length+1][target+1];
        //结果为 0 的情况均为 true
        for (int i = 0;i <= nums.length;i++)
            dp[i][0] = true;
        //动态规划
        for (int i = 1;i <= nums.length;i++)
            for (int j = 1;j <= target;j++){
                if (nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        //返回结果
        return dp[nums.length][target];


    }
}
