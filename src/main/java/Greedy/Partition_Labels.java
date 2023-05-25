package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition_Labels {
        /*
         * @author 林英杰
         * @since JDK 版本 1.8++
         * @Method Partition_Labels:划分字母区间
         * @param String s
         * @return 返回一个表示每个字符串片段的长度的列表。
         */
        public static List<Integer> Solution(String s){
                //申明存放结果的 ArrayList
                ArrayList<Integer> rseult = new ArrayList<>();
                //存放字母最后一次出现的下标索引
                int[] lastIndex = new int[26];
                for (int i = 0;i < s.length();i++){
                        //s.charAt(i) - 'a' 表示相应字母的下标 例如 ‘a’ 0  ‘b’ 1 ‘c’ 2
                        lastIndex[s.charAt(i) - 'a'] = i;
                }
                //区间起始，不小于开始第一个字母的最后出现的位置
                int start = 0,end = 0;
                while (end != s.length()-1){
                        end = lastIndex[s.charAt(start)-'a'];
                        //查看区间内是否存在最后出现下标更大的字母
                        for (int i = start+1;i < end;i++)
                                end = Math.max(lastIndex[s.charAt(i)-'a'],end);
                        rseult.add(end-start+1);
                        start = end + 1;
                }
                //返回结果
                return rseult;
        }
}
