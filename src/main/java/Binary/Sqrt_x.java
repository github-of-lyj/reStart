package Binary;

public class Sqrt_x {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method mySqrt:求算数平方根
     * @param int x
     * @return int ans
     * @Address https://leetcode.cn/problems/sqrtx/
     * @TitleName 69. x 的平方根
     */
    public int mySqrt(int x) {
        int l = 0, r = x, result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
