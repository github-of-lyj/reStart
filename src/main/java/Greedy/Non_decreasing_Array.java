package Greedy;

public class Non_decreasing_Array {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method checkPossibility
     * @param int[] nums
     * @return boolean result
     * @Address https://leetcode.cn/problems/non-decreasing-array/
     * @TitleName 665. 非递减数列
     */
    public boolean checkPossibility(int[] nums) {
        for(int i = 1;i < nums.length;i++){
            if(nums[i] < nums[i-1]) {
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                if(sorted(nums))
                    return true;
                nums[i-1] = temp;
                nums[i] = nums[i-1];
                return sorted(nums);
            }
        }
        return true;
    }

    public static boolean sorted(int[] nums){
        for (int i = 1;i < nums.length;i++)
            if (nums[i] < nums[i-1])
                return false;
        return true;
    }
}
