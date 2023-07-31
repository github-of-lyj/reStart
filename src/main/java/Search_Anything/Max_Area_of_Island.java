package Search_Anything;

import java.util.Stack;

public class Max_Area_of_Island {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method maxAreaOfIsland：求岛屿的最大面积
     * @param int[][] grid：海洋与陆地的组合数组
     * @return MaxArea：最大岛屿面积
     * @Address https://leetcode.cn/problems/max-area-of-island/
     * @TitleName 695. 岛屿的最大面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        //用于遍历某一点的上下左右四个方位的陆地是否存在
        int[] direction = {-1,0,1,0,-1};
        //分别为数组行的长度以及数据列的长度
        int row = grid.length;
        int column = row != 0 ? grid[0].length : 0;
        //上下左右四个方位的陆地的横坐标以及纵坐标
        int x,y;
        //当前岛屿面积以及最大岛屿面积
        int CurrentArea,MaxArea = 0;
        //对整块数组进行遍历
        for (int i = 0;i < row;i++)
            for (int j = 0;j < column;j++){
                //若是找到了某一块陆地，计算该块陆地属于的岛屿的面积
                if (grid[i][j] == 1){
                    CurrentArea = 1;
                    grid[i][j] = 0;
                    //记录对应块的横坐标以及纵坐标
                    //目的是为了方便对其上下左右相邻的块进行查找
                    Stack<Integer> island = new Stack<>();
                    island.add(j);
                    island.add(i);
                    //当岛屿不为空时，持续查找
                    while (!island.empty()){
                        int m = island.peek();
                        island.pop();
                        int n = island.peek();
                        island.pop();
                        //遍历上下左右四个方位
                        for (int k = 0;k < direction.length-1;k++){
                            //某一个方位对应的横坐标以及纵坐标
                            x = m + direction[k];
                            y = n + direction[k+1];
                            //对应的坐标是否合法
                            if (x >= 0 && x < grid.length)
                                if (y >=0 && y < grid[0].length)
                                    //若合法且是陆地，则将对应块置0，表示已经遍历过
                                    //并将其坐标置入 island 中以便后续的遍历
                                    if(grid[x][y] == 1){
                                        grid[x][y] = 0;
                                        CurrentArea++;
                                        island.add(y);
                                        island.add(x);
                                    }
                        }
                    }
                    //将二者之中的较大值保存下载
                    MaxArea = Math.max(MaxArea,CurrentArea);
                }
            }
        return MaxArea;
    }
}
