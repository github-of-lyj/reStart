package TwoPrice;

public class Merge_Sorted_Array {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method merge(int[] nums1, int m, int[] nums2, int n): 实现nums1数组和nums2数组的合并
     * @param  int[] nums1 int[] nums2：合并数组  int m, int n：合并数据的长度
     * @return void
     * @Address https://leetcode.cn/problems/merge-sorted-array/
     * @TitleName 88. 合并两个有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int num1 = 0,num2 = 0;
        int index = 0;
        while(num1 < m && num2 < n){
            if(nums1[num1] < nums2[num2]){
                result[index] = nums1[num1];
                num1++;
            }
            else{
                result[index] = nums2[num2];
                num2++;
            }
            index++;
        }
        while(num1 < m){
            result[index] = nums1[num1];
            index++;
            num1++;
        }
        while(num2 < n){
            result[index] = nums2[num2];
            index++;
            num2++;
        }
        for (int i = 0;i < m+n;i++)
            nums1[i] = result[i];
    }

    public void merge_NEW(int[] nums1, int m, int[] nums2, int n) {
        int num1 = m - 1;
        int num2 = n - 1;
        int key = m + n - 1;
        while (num1 >= 0 && num2 >= 0)
            nums1[key--] = nums1[num1] > nums2[num2] ?  nums1[num1--]:nums2[num2--];
        while (num2 >= 0)
            nums1[key--] = nums2[num2--];

    }
}
