package TwoPoint;

import java.util.Map;

public class Sum_of_Square_Numbers {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method judgeSquareSum:求是否存在最小平方和
     * @param int c：判断对象
     * @return boolean result
     * @Address https://leetcode.cn/problems/sum-of-square-numbers/
     * @TitleName 633. 平方数之和
     */
    public static boolean judgeSquareSum(int c) {
        //使用长整型防止数据溢出
        long end = (long) Math.sqrt(c);
        //双指针遍历查询是否存在对应结果
        long left = 0;
        long right = end;
        System.out.println(end);
        while (left <= right){
            if (left*left + right*right == c)
                return true;
            else {
                if (left*left + right*right < c)
                    left++;
                if (left*left + right*right > c)
                    right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600));
    }
}
