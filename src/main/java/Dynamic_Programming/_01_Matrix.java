package Dynamic_Programming;

import java.util.Arrays;

public class _01_Matrix {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method updateMatrix：输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     * @param mat：对应元素矩阵
     * @return dp：结果距离矩阵
     * @Address https://leetcode.cn/problems/01-matrix/description/
     * @TitleName 542. 01 矩阵
     */
    public int[][] updateMatrix(int[][] mat) {
        //初始化动态规划结果数组
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0;i < dp.length;i++)
            for (int j = 0;j < dp[0].length;j++)
                dp[i][j] = Integer.MAX_VALUE - 1;
        //从左上向右下搜索
        for (int i = 0;i < mat.length;i++)
            for (int j = 0;j < mat[0].length;j++){
                //对应位置元素为 0.则直接将 dp 数组对应位置 置0
                if (mat[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    //否则，对应位置 置二者之中的较小值
                    if (j > 0)
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + 1);
                    if (i > 0)
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + 1);
                }
            }
        //从右下向左上搜索
        //逻辑同左上至右下同理
        for (int i = mat.length-1;i >= 0;i--)
            for (int j = mat[0].length-1;j >= 0;j--){
                if (mat[i][j] != 0){
                    if (j < mat[0].length-1)
                        dp[i][j] = Math.min(dp[i][j],dp[i][j+1] + 1);
                    if (i < mat.length-1)
                        dp[i][j] = Math.min(dp[i][j],dp[i+1][j] + 1);
                }
            }
        return dp;
    }
}
