package Dynamic_Programming;

public class House_Robber_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method rob：你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * @param int[] nums
     * @return 最大偷窃金额
     * @Address https://leetcode.cn/problems/house-robber-ii/description/
     * @TitleName 213. 打家劫舍 II
     */
    public int rob(int[] nums) {
        //若只有一间房屋，最大偷窃金额即为房屋中所能够存取的金额数量
        if (nums.length == 1)
            return nums[0];
        //考虑首尾相连的情况
        //若是偷窃了第一间房屋，就不能偷窃最后一间房屋
        //若是偷窃了最后一间房屋，就不能偷窃第一间房屋
        //分别对以上两种情况进行动态规划数组的构建
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];
        dp1[1] = nums[0];
        dp2[2] = nums[1];
        //考虑偷窃第一间房屋，直到倒数第二间房屋为止
        for (int i = 2;i <= nums.length-1;i++){
            dp1[i] = Math.max(dp1[i-1] , dp1[i-2] + nums[i-1]);
        }
        //考虑偷窃第二间房屋，直到最后一间房屋为止
        for (int i = 3;i <= nums.length;i++)
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i-1]);
        //二者之中的最大值即为所能够偷盗的最大金额数量
        return Math.max(dp1[nums.length-1],dp2[nums.length]);
    }
}
