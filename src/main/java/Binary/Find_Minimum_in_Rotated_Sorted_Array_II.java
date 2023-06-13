package Binary;

public class Find_Minimum_in_Rotated_Sorted_Array_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method findMin：寻找旋转数组中的最小元素
     * @param int[] nums：找寻数组
     * @return 最小元素
     * @Address https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
     * @TitleName 154. 寻找旋转排序数组中的最小值 II
     */

    public static int findMin(int[] nums) {
        //特殊情况 数组长度为1，直接返回第一个数据
        if (nums.length == 1)
            return nums[0];
        //数组的起始位置和终止位置
        int start = 0,end = nums.length-1;
        //数组中点位置
        int mid = (start + end) / 2;
        //不断选择可能存在无序数组的一方，最终剩下两个元素，其中较小的即为最终结果
        while (end != start+1) {
            //如果中点和左端的数字相同，无法确定是左区间全部相同，还是右区间全部相同，此时将start的值+1
            if (nums[mid] == nums[start])
                start++;
            //中点位置的值小于等于尾部位置的值，说明从该点至尾部均有序，则答案位于开始位置到该点的数组当中
            else if (nums[mid] <= nums[end])
                end = mid;
            //同理中点位置的值大于尾部位置的值，说明从开始位置至该点均有序，则答案位于该点至结束位置的数组当中
            else
                start = mid;
            mid = (start + end) / 2;
        }
        return Math.min(nums[start], nums[end]);
    }


    public static void main(String[] args) {
        int[] arr = {10,1,10,10,10};
        System.out.println(findMin(arr));
    }
}
