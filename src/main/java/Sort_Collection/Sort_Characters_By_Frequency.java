package Sort_Collection;

import java.util.*;

public class Sort_Characters_By_Frequency {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method frequencySort：根据字符出现频率排序
     * @param String s：待排序字符串
     * @return String result：根据字符出现频率排序的字符串 result
     * @Address https://leetcode.cn/problems/sort-characters-by-frequency/
     * @TitleName 根据字符出现频率排序
     */
    //整体仍然是桶排序的思想
    public String frequencySort(String s) {
        //使用 HashMap 记录字符串 s 中各个字符的频率
        Map<Character,Integer> map =  new HashMap<>();
        for (int i = 0;i < s.length();i++)
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
        //以在 HashMap 中记录得到频率作为下标存储进对应的 List 当中
        List<Character>[] list = new LinkedList[s.length()+1];
        for (char c : map.keySet()) {
            int i = map.get(c);
            if (list[i] == null)
                list[i] = new LinkedList<>();
            list[i].add(c);
        }
        //根据字符出现的频率从大到小，添加构建结果 result 字符串
        //值得注意的是根据字符出现频率的不同，所需要添加的字符次数也不相同
        StringBuilder result = new StringBuilder();
        for (int i = list.length-1;i >= 0;i--)
            if (list[i] != null)
                for (char c : list[i])
                    //根据出现频率添加相应的字符数量
                    for (int j = 0;j < i;j++)
                        result.append(c);
        return result.toString();
    }
}
