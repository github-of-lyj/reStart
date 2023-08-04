package Search_Anything;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method combine：给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 combineTry：回溯法寻找可能符合题意的答案
     * @param n：界定范围 [1, n]   k：最终结果的组合为 k 个数
     * @return List<List<Integer>> result
     * @Address https://leetcode.cn/problems/combinations/
     * @TitleName 77. 组合
     */
    public static List<List<Integer>> combine(int n, int k) {
        //结果集合 result 以及 回溯过程当中存储当前某一结果的集合 list
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //判断某个数是否已经加入当前结果集合 list 的 mark 数组
        Boolean[] mark = new Boolean[n+1];
        for (int i = 0;i < n + 1;i++)
            mark[i] = false;
        //回溯法求解
        combineTry(n,k,mark,result,list,1);
        return result;
    }

    //为了防止最终结果中出现类似 [1,2] [2,1] 的重复求解情况
    //采用 currentMax 记录当前结果集合 list 中的最大数值，确保集合中的数据顺序为从小到大
    public static void combineTry(int n,int k,Boolean[] mark,List<List<Integer>> result,List<Integer> list,int currentMax){
        //当前结果集合 list 的长度符合要求
        //申明一个 temp List集合复制 list 中的数据
        //将其加入到 result 中
        if (list.size() == k){
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        for (int i = 0; i < n;i++){
            //要加入的数据是在范围之内
            //以下两个 if 条件若有一个不满足均需要 continue 进行下一个 for 循环
            if (i + currentMax <= n)
                //要加入的数据先前还未被加入过
                if (!mark[i + currentMax]){
                    mark[i + currentMax] = true;
                    list.add(i + currentMax);
                }else
                    continue;
            else
                continue;
            combineTry(n,k,mark,result,list,i + currentMax);
            //回溯操作，在 list 删除对应的元素
            //并复位 mark 数组
            list.remove(Integer.valueOf(i + currentMax));
            mark[i + currentMax] = false;
        }
    }
}
