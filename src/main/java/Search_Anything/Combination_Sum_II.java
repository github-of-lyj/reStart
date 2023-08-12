package Search_Anything;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Combination_Sum_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method combinationSum2(int[] candidates, int target)：找出 candidates 中所有可以使数字和为 target 的组合。
     * @param int[] candidates：候选者数组  int target：目标数
     * @return 结果集合 result
     * @Address https://leetcode.cn/problems/combination-sum-ii/description/
     * @TitleName 40. 组合总和 II
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //结果集合 result
        //遍历过程中的一种可能集合 oneResult
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneResult = new ArrayList<>();
        //某一位置的数据是否已经被使用的标记
        boolean[] isUsed = new boolean[candidates.length];
        //事先对数组进行排序
        Arrays.sort(candidates);
        solve(candidates,result,oneResult,isUsed,0,0,target);
        return result;
    }

    void solve(int[] candidates, List<List<Integer>> result,List<Integer> oneResult,boolean[] isUsed,int currentSum,int currentPos,int target){
        //当当前总和等于目标时，将当前 oneResult 加入 result
        if (currentSum == target){
            result.add(new ArrayList<>(oneResult));
            return;
        }
        //每次从上一次选择数据的位置开始，确保选择数据的顺序是从小到大的
        for (int i = currentPos;i < candidates.length;i++){
            //isUsed[i]：数据被使用过
            //(currentSum + candidates[i]) > target：同当前数据相加超过阈值（target）
            //candidates[i] == candidates[i-1] && !isUsed[i-1]：当前选择的数字和上一次选择的数字是一样的
            //不符合条件通通跳过
            if (isUsed[i] || (currentSum + candidates[i]) > target || (i > 0 && candidates[i] == candidates[i-1] && !isUsed[i-1]))
                continue;
            //修改对应标记
            isUsed[i] = true;
            oneResult.add(candidates[i]);
            solve(candidates, result, oneResult, isUsed, currentSum + candidates[i],i,target);
            //回溯对应标记
            isUsed[i] = false;
            oneResult.remove((Integer) candidates[i]);
        }
    }
}
