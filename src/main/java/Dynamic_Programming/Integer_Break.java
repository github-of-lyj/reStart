package Dynamic_Programming;

public class Integer_Break {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method integerBreak
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化
     * 返回 你可以获得的最大乘积
     * @param int n
     * @return 所能获得的最大乘积
     * @Address https://leetcode.cn/problems/integer-break/description/
     * @TitleName 343. 整数拆分
     */
    public int integerBreak(int n) {
        //数学归纳方法，乘积的情况为划分为尽可能少的 3 的情况
        if (n <= 3)
            return n-1;
        //商
        int quotient = n / 3;
        //余数
        int residue = n % 3;
        //恰好划分为这么 quotient 个 3
        if (residue == 0)
            return (int) Math.pow(3,quotient);
        else
            //余数为 1 时，最少可以划分为 quotient - 1 个 3
            if (residue == 1)
                return (int) (Math.pow(3,quotient - 1) * 4);
            else
                //余数为 2 时，最少可以划分为 quotient 个 3
                return (int) (Math.pow(3,quotient - 1) * 2);
    }
}
