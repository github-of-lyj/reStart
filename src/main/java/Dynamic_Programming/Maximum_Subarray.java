package Dynamic_Programming;

public class Maximum_Subarray {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method maxSubArray：
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组是数组中的一个连续部分。
     * @param int[] nums
     * @return MaxResult
     * @Address https://leetcode.cn/problems/maximum-subarray/description/
     * @TitleName 53. 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        //动态规划数组
        //dp[i] 表示以第 i 个元素作为结尾时，所能够得到的最大连续子数组和
        int[] dp = new int[nums.length+1];
        //当前找到的连续子数组最大和
        int MaxResult = nums[0];
        //初始化
        dp[1] = nums[0];
        for (int i = 2;i <= nums.length;i++){
            //考虑以先前的元素为结尾所能构成的最大连续子数组和
            //若其小于 0，表明其对于以当前元素为结尾的连续子数组的最优结果没有贡献
            //当前的最优结果即为对应 nums 数组位置的值
            if (dp[i-1] < 0)
                dp[i] = nums[i-1];
            else
                //否则，当前的最优结果即为对应 nums 数组位置的值加上先前的 dp[i-1]
                dp[i] = dp[i-1] + nums[i-1];
            MaxResult = Math.max(MaxResult,dp[i]);
        }
        //返回最大值
        return MaxResult;
    }
}
