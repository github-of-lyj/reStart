package Dynamic_Programming;

public class Maximal_Square {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method maximalSquare：返回矩阵中存在的最大正方形面积
     * @param char[][] matrix：对应矩阵
     * @return maxLength*maxLength（其中 maxLength 为最大矩阵边长）
     * @Address https://leetcode.cn/problems/maximal-square/description/
     * @TitleName 221. 最大正方形
     */
    public int maximalSquare(char[][] matrix) {
        //动态规划数组
        //dp[i][j] 表示以 matrix 中 i、j下标的数字为右下角所能构成的最大正方形边长
        int[][] dp = new int[matrix.length][matrix[0].length];
        //当前最大正方形边长，初始为 0
        int maxLength = 0;
        //初始化第一行 第一列
        for (int i = 0;i < matrix[0].length;i++)
            if (matrix[0][i] == '1'){
                dp[0][i] = 1;
                maxLength = 1;
            }
            else
                dp[0][i] = 0;
        for (int j = 0;j < matrix.length;j++)
            if (matrix[j][0] == '1'){
                dp[j][0] = 1;
                maxLength = 1;
            }
            else
                dp[j][0] = 0;
        //填充剩余的动态规划数组
        //能够构成的最大正方形边长为 临近三点中的最小值 + 1
        for (int i = 1;i < matrix.length;i++)
            for (int j = 1;j < matrix[0].length;j++){
                if (matrix[i][j] == '1') {
                    int minPerhaps = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    minPerhaps = Math.min(dp[i - 1][j - 1], minPerhaps);
                    dp[i][j] = minPerhaps + 1;
                    maxLength = Math.max(dp[i][j],maxLength);
                }
            }
        //返回对应面积
        return maxLength*maxLength;
    }
}
