package Search_Anything;

import java.util.*;

public class Permutations_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method permuteUnique：全排列进阶，数组中存在重复元素
     * @param int[] nums：待排列数组
     * @return 全排列集合 List
     * @Address https://leetcode.cn/problems/permutations-ii/description/
     * @TitleName 47. 全排列 II
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        //全排列结果集合 result
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        //排列过程中的某一种结果 oneResult
        List<Integer> oneResult = new ArrayList<>();
        //数字是否被使用过的标记 isUsed
        boolean[] isUsed = new boolean[nums.length];
        //方便后续排序，将原数组率先排序
        Arrays.sort(nums);
        uniqueBack(nums,result,oneResult,isUsed,0);
        return result;

    }

    void uniqueBack(int[] nums,List<List<Integer>> result,List<Integer> oneResult,boolean[] isUsed,int pos){
        //当 pos 为 nums.length 时，一趟排列完成
        if (pos == nums.length){
            List<Integer> temp = new ArrayList<>(oneResult);
            result.add(temp);
            return;
        }
        //选择将要加入 oneResult 中的数组元素
        for (int i = 0; i < nums.length;i++){
            //该元素已经被使用过，不予考虑
            //该元素未被使用过，但是该元素和先前使用的元素数值相同，同样不予考虑
            //!isUsed[i-1]：
            //对于同一位置，若将选择相同的元素，会因为 isUsed[i-1]为 false（因为回溯，使用的标记从 true变为 false） 进入 continue 语句
            //对于不同位置，若要选择和上一位置相同的元素，此时 isUsed[i-1]为 true（因为相应元素已经被上一个元素使用）,不会影响选择
            if (isUsed[i] || (i > 0 && nums[i] == nums[i - 1] && !isUsed[i-1]))
                continue;
            //加入元素并修改标记
            oneResult.add(nums[i]);
            isUsed[i] = true;
            uniqueBack(nums,result,oneResult,isUsed,pos+1);
            //回溯
            oneResult.remove(pos);
            isUsed[i] = false;
        }
    }
}
