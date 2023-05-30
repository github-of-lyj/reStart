package Practice;
import java.util.*;
public class Longest_Valid_Parentheses {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method longestValidParentheses:求一系列括号的最长有效括号
     * @param String s:输入字符串
     * @return int longestValidParentheses:最长有效括号
     * @Address https://leetcode.cn/problems/longest-valid-parentheses/
     * @TitleName 最长有效括号
     */

    public static int longestValidParentheses(String s) {
        //
        if(s.length() == 0)
            return 0;
        Stack<Integer> kuohao = new Stack<>();
        Set<Integer> youxiao = new HashSet<>();
        int[] result = new int[s.length()];
        result[0] = 0;
        if (s.charAt(0) == '(')
            kuohao.add(0);
        for (int i = 1;i < s.length();i++){
            if (s.charAt(i) == ')' && !kuohao.isEmpty()){
                Integer pop = kuohao.pop();
                youxiao.add(pop);
                youxiao.add(i);
                result[i] = result[i-1] + 1;
            }else{
                result[i] = result[i-1];
                if (s.charAt(i) == '(')
                    kuohao.add(i);
            }
        }
        if (youxiao.isEmpty())
            return 0;
        System.out.println(youxiao);
        Iterator<Integer> iterator = youxiao.iterator();
        Integer pre = iterator.next();
        int curlength = 1,maxlength = 1;
        while (iterator.hasNext()){
            Integer cur = iterator.next();
            if (cur-pre == 1)
                curlength++;
            else {
                if (curlength > maxlength)
                    maxlength = curlength;
                curlength = 1;
            }
            pre = cur;
        }
        if (curlength > maxlength)
            maxlength = curlength;
        return maxlength == 1? result[s.length()-1]*2 : maxlength;
    }

    public static void main(String[] args) {
        String s = ")(())))(())())";
        System.out.println(longestValidParentheses(s));
    }

}
