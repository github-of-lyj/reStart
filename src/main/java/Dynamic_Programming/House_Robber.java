package Dynamic_Programming;

public class House_Robber {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method rob：返回能够获取的最大金额
     * @param nums：房子以及房子当中的钱的分布数组
     * @return 一个晚上最多能够得到多少钱
     * @Address  https://leetcode.cn/problems/house-robber/description/
     * @TitleName  198. 打家劫舍
     */
    public int rob(int[] nums) {
        //结果数组
        //result[i]表示考虑前 i 个房子能够得到的最大金额
        int[] result = new int[nums.length+1];
        //初始化
        //考虑前 0 个房子，没有钱可以偷
        //考虑前 1 个房子，能够偷的钱就等于第一个房子里放的钱数
        result[0] = 0;;
        result[1] = nums[0];
        //动态规划
        for (int i = 2;i <= nums.length;i++)
            //考虑前 i 个房子所能够偷到的最多的钱数 等于
            //考虑前 i-1 个房子所能偷到的最大钱数 以及  考虑前 i-2 个房子所能偷到的最大钱数 加上第 i 个房子当中的钱数
            //二者当中的最大值
            result[i] = Math.max(result[i - 1], nums[i-1] + result[i - 2]);
        return result[nums.length];
    }
}
