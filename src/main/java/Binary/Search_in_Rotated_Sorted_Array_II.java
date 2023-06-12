package Binary;

public class Search_in_Rotated_Sorted_Array_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method search:搜索旋转排序数组 II
     * @param int[] nums:目标数组  int target:目标
     * @return boolean result
     * @Address  https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
     * @TitleName 81. 搜索旋转排序数组 II
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 1){
            return nums[0] == target;
        }
        int l = 1;
        int r = nums.length;
        for(;l < r;l++){
            if(nums[l-1] == target)
                return true;
            if(nums[l] < nums[l-1])
                break;
        }
        if(l == r)
            l = 0;
        int mid;
        while (l < r){
            mid = (l + r - 1) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return false;
    }

}
