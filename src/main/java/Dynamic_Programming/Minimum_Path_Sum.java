package Dynamic_Programming;

public class Minimum_Path_Sum {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method minPathSum：最小路径和
     * @param grid：路径数组
     * @return 到达右下角的最小路径查毒
     * @Address https://leetcode.cn/problems/minimum-path-sum/description/
     * @TitleName  64. 最小路径和
     */
    public int minPathSum(int[][] grid) {
        //动态规划数组
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        //构建 dp 数组，由于只能往右或者往下移动
        //因此状态转移方程为：dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        //需要考虑左方和上方的格子是否存在的不同情况
        for (int i = 0;i < grid.length;i++)
            for (int j = 0;j < grid[0].length;j++){
                if (i-1 >= 0 && j-1 < 0)
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                if (i-1 < 0 && j-1 >= 0)
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                if (i-1 >= 0 && j-1 >= 0)
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        return dp[grid.length-1][grid[0].length-1];
    }
}
