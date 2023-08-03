package Search_Anything;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method permute：对于给定数组，返回一个包含其全排列的 result List集合
     * @param int[] nums：给定数组  List<List<Integer>> result：结果集合
     * @return List<List<Integer>> result
     * @Address https://leetcode.cn/problems/permutations/
     * @TitleName 46. 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        //声明 result 结果集合
        List<List<Integer>> result = new ArrayList<>();
        //调用递归回溯方法
        //currentLength 为某一种结果的当前长度
        lookBack(nums,result,0);
        return result;
    }

    public void lookBack(int[] nums,List<List<Integer>> result,int currentLength){
        //当 currentLength 长度为 nums.length - 1 时，认为一种合法情况已经发生
        //将其加入 result 数组
        if (currentLength == nums.length - 1){
            List<Integer> temp = new ArrayList<>();
            for (int i : nums)
                temp.add(i);
            result.add(temp);
            return;
        }
        //每一位都可以与任一位于当前位置与后续位置的多个位置上的元素进行交换
        for (int i = currentLength;i < nums.length;i++){
            //交换元素
            int temp = nums[i];
            nums[i] = nums[currentLength];
            nums[currentLength] = temp;
            lookBack(nums,result,currentLength + 1);
            //回溯操作
            temp = nums[i];
            nums[i] = nums[currentLength];
            nums[currentLength] = temp;
        }
    }
}
