package Sort_Collection;

public class Sort_Colors {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method sortColors：颜色分类，将代表不同颜色的三个值按照 0 1 2 的顺序排列
     * @param int[] nums：待排序数组
     * @return 有序数组
     * @Address https://leetcode.cn/problems/sort-colors/
     * @TitleName 75. 颜色分类
     */
    public void sortColors(int[] nums) {
        //双指针
        //左指针用于交换 0  右指针用于交换 1
        int l = 0,r = nums.length-1;
        //从左往右遍历 nums 中的元素
        for (int i = 0;i < nums.length;i++){
            //当遍历到的元素为 2 时，将元素与右指针所指向的值交换
            //将右指针的值减一
            //考虑到换过来的元素仍有可能是 2，因此需要对 nums[i]一直进行进行
            //当 i >= r 时，说明后续遍历的元素均为 2，可以结束遍历
            while (i < r && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            }
            //当遍历到的元素为 2 时，将元素与左指针所指向的值交换
            //将左指针的值加一
            //由于是从左向右遍历的，因此交换过来的元素必不可能是 0 或 2
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }
}
