package Sort_Collection;

import java.util.*;

public class Top_K_Frequent_Elements {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method  topKFrequent；基于桶排序求解「前 K 个高频元素」
     * @param
     * @return
     * @Address
     * @TitleName
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 使用 HashMap，统计每个元素出现的次数
        // 元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            //如果 HashMap 中已经包含该元素，则将其原有的值（出现频率）加一
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //桶排序
        //list 最大的情况是 nums 中的元素均为同一元素，此时出现频率为 nums.length，因此至少需要 nums.length + 1 的大小来进行存储
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int num : map.keySet()) {
            // 获取对应数据 num 出现的次数 frequency 作为下标
            int frequency = map.get(num);
            if (list[frequency] == null) {
                list[frequency] = new ArrayList();
            }
            list[frequency].add(num);
        }
        //结果数组以及结果数组的当前下标
        int[] res = new int[k];
        int curIndex = 0;
        //因此先前已频率作为 list 数组的下标
        //倒序遍历 list 数组获取出现频次从大到小的排列
        for (int i = list.length - 1; i >= 0 && curIndex < k; i--) {
            if (list[i] == null) continue;
            //同一频次的数据可能有多个，要全部放入 res 数组当中
            for (int result : list[i])
                res[curIndex++] = result;
        }
        return res;
    }
}
