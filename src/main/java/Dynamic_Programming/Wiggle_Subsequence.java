package Dynamic_Programming;

public class Wiggle_Subsequence {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method wiggleMaxLength：如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     * @param int[] nums
     * @return 返回 nums 中作为 摆动序列 的 最长子序列的长度
     * @Address https://leetcode.cn/problems/wiggle-subsequence/description/
     * @TitleName 376. 摆动序列
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        //up[i] 为考虑前 i 个数字的上升摆动序列的长度
        //down[j] 为考虑前 j 个数字的下降摆动序列的长度
        //上升摆动序列的最后一个元素呈现上升趋势
        //下降摆动序列的最后一个元素呈现下降趋势
        int[] up = new int[nums.length + 1];
        int[] down = new int[nums.length + 1];
        //考虑第一个元素的摆动序列的长度为 1
        up[1] = down[1] = 1;
        for (int i = 2; i <= nums.length; i++) {
            if (nums[i - 1] > nums[i - 2]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i - 1] < nums[i - 2]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[nums.length], down[nums.length]);
    }
}
