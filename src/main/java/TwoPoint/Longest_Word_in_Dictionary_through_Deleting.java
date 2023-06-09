package TwoPoint;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Longest_Word_in_Dictionary_through_Deleting {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method findLongestWord:通过删除字母匹配到字典里最长单词
     * @param String s:匹配字符串  List<String> dictionary：存储相应字符串的字典数组
     * @return  str or ""
     * @Address https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/
     * @TitleName 524. 通过删除字母匹配到字典里最长单词
     */
    public String findLongestWord(String s, List<String> dictionary) {
        //事先排序
        //按照字符串长度进行排序，字符串长度相同时，按照字典顺序进行排序
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length())
                    return s2.length() - s1.length();
                return s1.compareTo(s2);
            }
        });
        //最先匹配成功的则为最佳答案
        for (String str : dictionary) {
            int m = s.length();
            int n = str.length();
            int i = 0;
            int j = 0;
            while (i < m && j < n){
                if (s.charAt(i) == str.charAt(j))
                    j++;
                i++;
            }
            if (j == n)
                return str;
        }
        return "";
    }

}
