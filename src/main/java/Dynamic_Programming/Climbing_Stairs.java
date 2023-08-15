package Dynamic_Programming;

public class Climbing_Stairs {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method climbStairs：爬楼梯的不同方法
     * @param int n：要爬的楼梯的层数
     * @return 一共有多少种方法
     * @Address https://leetcode.cn/problems/climbing-stairs/description/
     * @TitleName 70. 爬楼梯

     */
    public int climbStairs(int n) {
        //当 n <= 2,爬楼梯的方法就等于要爬楼梯的层数
        if (n <= 2)
            return n;
        //动态规划
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        //若要爬 i 层楼梯，所需要的方法数量等同于 爬 i-1 层楼梯的方法数量 加上 爬 i-2 层楼梯的方法数量
        for (int i = 3;i <= n;i++)
            result[i] = result[i-1] + result[i-2];
        return result[n];
    }
}
