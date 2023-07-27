package Sort_Collection;

public class Kth_Largest_Element_in_an_Array {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method findKthLargest：查询第 k 大的元素   quickSelect：简单快速选择，返回以数组中第一个元素 pivot 的下标
     * @param nums：待排序数组  k：给出所要求的的 kth  l：数组起始位置  r：数组终止位置
     * @return 第 k 大的元素
     * @Address https://leetcode.cn/problems/kth-largest-element-in-an-array/
     * @TitleName 215. 数组中的第K个最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        //初始化数组起始以及终止位置
        int l = 0,r = nums.length-1;
        //初始化数组目标元素应当在的位置
        int target = nums.length-k;
        //循环遍历元素，当 l == r 时，表明只有一个待选元素，直接返回结果
        while (l < r){
            //返回 nums[l] 的元素应当在的位置
            int mid = quickSelect(nums,l,r);
            //和期望位置相同，直接返回
            if (mid == target)
                return nums[target];
            else
                //求得位置比期望位置大，缩小右区间
                //求得位置比期望位置小，缩小左区间
                if (mid > target)
                    r = mid - 1;
                else
                    l = mid + 1;
        }
        return nums[l];
    }

    //快速选择过程
    int quickSelect(int[] nums,int l,int r){
        int lIndex = l, rIndex = r;
        //基准位置
        int pivot = nums[lIndex];
        //比基准元素大的元素放在基准元素的右边
        //比基准元素小的元素放在基准元素的左边
        while (lIndex < rIndex){
            while (lIndex < rIndex && nums[rIndex] > pivot)
                rIndex--;
            nums[lIndex] = nums[rIndex];
            while (lIndex < rIndex && nums[lIndex] <= pivot)
                lIndex++;
            nums[rIndex] = nums[lIndex];
        }
        //基准元素位置赋值
        nums[lIndex] = pivot;
        return lIndex;
    }
}
