package Binary;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method searchRange 寻找值为 target 的开始位置和终止位置
     * @param int[] nums 目标数组 int target：目标数据
     * @return result：结果数组
     * @Address https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
     * @TitleName 34. 在排序数组中查找元素的第一个和最后一个位置
     */

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length == 0)
            return result;
        int begin = -1;
        int left = 0,right = nums.length-1;
        int mid;
        while (left <= right){
            mid = (left + right)/2;
            if (nums[mid] == target) {
                begin = mid;
                break;
            }else {
                if (nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        if (begin != -1){
            result[0] = begin;
            result[1] = begin;
            int temp = begin + 1;
            while (temp <= nums.length - 1){
                if (nums[temp] == target){
                    result[1] = temp;
                }
                temp++;
            }
            temp = begin - 1;
            while(temp >= 0){
                if (nums[temp] == target){
                    result[0] = temp;
                }
                temp--;
            }
        }
        return result;
    }
}
