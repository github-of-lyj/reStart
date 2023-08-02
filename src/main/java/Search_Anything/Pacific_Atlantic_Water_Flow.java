package Search_Anything;

import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method pacificAtlantic：返回同时能够流向太平洋和大西洋的雨水位置
     * @param direction：方向数组，用于遍历上下左右四个方向  heights：岛屿上的雨水所在不同位置的海拔高度
     * @return result：符合条件的雨水位置
     * @Address https://leetcode.cn/problems/pacific-atlantic-water-flow/
     * @TitleName 太平洋大西洋水流问题
     */
    int[] direction = {-1,0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //岛屿的行高以及列高
        int rowLength = heights.length;
        int columnLength = heights[0].length;
        //分别用于存储能够到达太平洋以及能够到达大西洋的块
        //能够到达则将相应位置的值置为 true
        Boolean[][] canReachPacific = new Boolean[rowLength][columnLength];
        Boolean[][] canReachAtlantic = new Boolean[rowLength][columnLength];
        for (int i = 0;i < rowLength;i++)
            for (int j = 0;j < columnLength;j++){
                canReachPacific[i][j] = false;
                canReachAtlantic[i][j] = true;
            }

        //数组的左上部分（即左边界以及上边界）临接着太平洋
        //对左边界以及其相邻的雨水块进行遍历
        for (int leftBorder = 0;leftBorder < rowLength;leftBorder++)
            dfs(heights,canReachPacific,leftBorder,0);
        //对上边界以及其相邻的雨水块进行遍历
        for (int topBorder = 0;topBorder < columnLength;topBorder++)
            dfs(heights,canReachPacific,0,topBorder);
        //数组的右下部分（即右边界以及下边界）临接着大西洋
        //对右边界以及其相邻的雨水块进行遍历
        for (int rightBorder = 0;rightBorder < rowLength;rightBorder++)
            dfs(heights,canReachAtlantic,rightBorder,columnLength-1);
        //对下边界以及其相邻的雨水块进行遍历
        for (int lowerBorder = 0;lowerBorder < columnLength;lowerBorder++)
            dfs(heights,canReachAtlantic,rowLength-1,lowerBorder);
        //结果数组
        List<List<Integer>> result = new ArrayList<>();
        //当某一雨水块满足既能够流到太平洋又能够流到大西洋时候
        //将其加入结果 result 数组
        for (int i = 0;i < rowLength;i++)
            for (int j = 0;j < columnLength;j++)
                if (canReachPacific[i][j] && canReachAtlantic[i][j]){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
        return result;
    }

    public void dfs(int[][] heights,Boolean[][] canReach,int currentRow,int currentColumn){
        //某一雨水块先前已经被访问过 直接返回即可
        if (canReach[currentRow][currentColumn])
            return;
        canReach[currentRow][currentColumn] = true;
        //分别对相邻的雨水块再进行遍历
        for (int i = 0;i < direction.length-1;i++){
            int newRow = currentRow + direction[i];
            int newColumn = currentColumn + direction[i+1];
            //访问雨水块的位置合法
            //访问雨水块的海拔大于等于当前雨水块
            if (newRow >= 0 && newRow < heights.length)
                if (newColumn >= 0 && newColumn < heights[0].length)
                    if (heights[newRow][newColumn] >= heights[currentRow][currentColumn])
                        dfs(heights,canReach,newRow,newColumn);
        }
    }
}
