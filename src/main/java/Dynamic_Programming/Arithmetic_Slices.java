package Dynamic_Programming;

import java.util.Arrays;

public class Arithmetic_Slices {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method numberOfArithmeticSlices；返回等差数列的个数
     * @param int[] nums：构成等差数列数据的数组
     * @return result：最终的等差数列数量
     * @Address  https://leetcode.cn/problems/arithmetic-slices/description/
     * @TitleName 413. 等差数列划分
     */
    public int numberOfArithmeticSlices(int[] nums) {
        //最终结果数
        int result = 0;
        //数组长度小于2，直接返回 0
        if (nums.length <= 2)
            return 0;
        //动态规划数组
        int[] dp = new int[nums.length];
        //从第三个元素开始进行动态规划
        //举例
        //[1, 2, 3, 4, 5, 19, 20, 30, 40]。答案为7。
        //首先容易观察到：
        //长度为3的等差数列，可以贡献1种答案。例如 [1,2,3] 。
        //长度为4的等差数列，可以贡献3种答案。例如[1,2,3,4]，有长度为3的子数列[1,2,3]和[2,3,4]两种。以及长度为4的数列[1,2,3,4]一种。一共是1+2=3种。
        //长度为5的等差数列，可以贡献6种答案。例如[1,2,3,4,5]，有长度为3的子数列[1,2,3]和[2,3,4]和[3,4,5]三种，以及长度为4的子数列[1,2,3,4]和[2,3,4,5]两种，以及长度为5的数列[1,2,3,4,5]一种。一共是1+2+3=6种。
        //假设我们已经找到了一个长度为3的等差数列。它可以给答案带来一种贡献。
        //如果遍历到下一个数时，发现这个数可以拼接到前面长度为3的等差数列的末尾，形成一个长度为4的等差数列，那么把长度为3的等差数列的答案贡献数加一，就是由于这次拼接带来的新的贡献数。当前长度为4的等差数列，这次拼接新的贡献量为1+1=2。
        //同理，下一次遍历又发现一个数可以在已发现的长度为4的等差数列的基础上，拼接成长度为5的等差数列，那么新的贡献量就是2+1=3.
        // 如果下一个数无法与前面的数列行成新的等差数列，那么贡献量清零。
        for (int i = 2;i < nums.length;i++)
            //构成等差数组则在前面的基础上 + 1
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                dp[i] = dp[i-1] + 1;
        //数组的所有结果相加即为最终的等差数列个数
        for (int one: dp)
            result+=one;
        return result;
    }
}
