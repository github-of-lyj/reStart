package TwoPrice;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method minWindow:求最小字符串包含 t 中的所有字母
     * @param String s, String t
     * @return 存在返回相应子字符串，不存在返回 “”
     * @Address https://leetcode.cn/problems/minimum-window-substring/
     * @TitleName 76. 最小覆盖子串
     */

    public static String minWindow(String s, String t) {
        //Map集合 need 用于存放所需要的的字符个数
        Map<Character,Integer> need = new HashMap<>();
        for (int i = 0;i < t.length();i++){
            if (!need.containsKey(t.charAt(i)))
                need.put(t.charAt(i),1);
            else
                need.put(t.charAt(i),need.get(t.charAt(i))+1);
        }
        //维护 currentNeed 记录当前还需要的字符类型个数
        int currentNeed = need.size();
        //滑动窗口左右下标
        int left = 0,right = 0;
        //初始化 s + t
        String minLength = s + t;
        //当前的字符串，用于判断最小字符串
        String curLength;
        while (true){
            //特殊情况
            if (left == right && currentNeed == 0)
                break;
            //寻找符合条件的 right 位置
            while (currentNeed != 0){
                if (right == s.length())
                    break;
                if (need.containsKey(s.charAt(right))){
                    need.put(s.charAt(right),need.get(s.charAt(right))-1);
                    if (need.get(s.charAt(right)) == 0){
                        currentNeed--;
                        if (currentNeed == 0)
                            break;
                    }
                }
                if (right != s.length()-1)
                    right++;
                else
                    break;
            }
            if (currentNeed > 0)
                break;
            //寻找符合条件的 left 位置
            while (left < right){
                if (need.containsKey(s.charAt(left))){
                    if (need.get(s.charAt(left)) + 1 <= 0)
                        need.put(s.charAt(left),need.get(s.charAt(left))+1);
                    else
                        break;
                }
                left++;
            }
            //分割符合条件的字符串并且进行赋值
            curLength = s.substring(left,right+1);
            if (curLength.length() < minLength.length())
                minLength = curLength;
            //考虑其他的情况
            if (left < right){
                need.put(s.charAt(left),need.get(s.charAt(left))+1);
                currentNeed++;
                left++;
                right++;
            }
        }
        return minLength.equals(s + t) ?  "": minLength;
    }


    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.println(minWindow(s, t));
    }
}
