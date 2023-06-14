package Binary;

public class Single_Element_in_a_Sorted_Array {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method singleNonDuplicate：找寻有序数组中的单一元素
     * @param int[] nums：查询数组
     * @return nums[mid]：最终单一元素
     * @Address https://leetcode.cn/problems/single-element-in-a-sorted-array/
     * @TitleName 540. 有序数组中的单一元素
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) / 2;
        //考虑去除中点后左右区间的元素数量
        //由此判断单一元素是存在于左区间当中还是存在于右区间当中
        while(left < right){
            //偶数情况
            if( ((right - left) / 2) % 2 == 0){
                if(nums[mid] == nums[mid+1])
                    left = mid;
                else if(nums[mid] == nums[mid-1])
                    right = mid;
                else
                    return nums[mid];
            }
            //奇数情况
            else{
                if(nums[mid] == nums[mid+1])
                    right = mid-1;
                else if(nums[mid] == nums[mid-1])
                    left = mid+1;
                else
                    return nums[mid];
            }
            mid = (left + right) / 2;
        }
        return nums[mid];
    }
}
