package Search_Anything;

import java.util.ArrayDeque;
import java.util.Queue;

public class Shortest_Bridge {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method shortestBridge：最短的桥
     * @param int[][] grid：陆地 水域二元矩阵
     * @return 返回桥的最短长度（即必须翻转的 0 的最小数目）
     * @Address https://leetcode.cn/problems/shortest-bridge/
     * @TitleName 934. 最短的桥
     */
    //方向数组
    int[] dirs = {-1,0,1,0,-1};
    public int shortestBridge(int[][] grid) {
        //二元矩阵长度
        int n = grid.length;
        //寻找第一座岛并将其陆地元素均置为 -1
        //是否会影响到第二座岛导致程序出现 bug？
        //并不会，因为在对第一座岛进行深度优先搜索之后，紧接着就会根据搜索结果进行广度优先搜索
        //后续的二重循环并不会继续
        for (int i = 0;i < n;i++)
            for (int j = 0;j < n;j++)
                if (grid[i][j] == 1){
                    //队列：用于存储第一座岛的陆地位置
                    //利用深度优先遍历第一座岛
                    Queue<int[]> queue = new ArrayDeque<>();
                    dfs(grid,queue,i,j);
                    //最短桥的长度
                    int step = 0;
                    //队列不空则继续遍历
                    while (!queue.isEmpty()){
                        //每一轮的都需要遍历完当前队列中的所有元素（不包括过程中加入的元素）
                        //然后才考虑对 step 进行 +1 的操作
                        int queueLength = queue.size();
                        for (int k = 0;k < queueLength;k++){
                            //陆地的横坐标以及纵坐标
                            int[] cur = queue.poll();
                            int x = cur[0],y = cur[1];
                            //对陆地的周围方位进行遍历
                            for (int pos = 0;pos < dirs.length-1;pos++){
                                //周围方位的坐标
                                int newX = x + dirs[pos];
                                int newY = y + dirs[pos+1];
                                //判断坐标是否合法
                                if (newX >= 0 && newX < grid.length)
                                    if (newY >= 0 && newY < grid.length)
                                        //访问到了第二座岛的某一块，此时可以直接返回 step，即为结果
                                        if (grid[newX][newY] == 1)
                                            return step;
                                        //否则将该位置的值设置为 -1，并将其加入相应的 queue 中
                                        else if (grid[newX][newY] == 0){
                                            grid[newX][newY] = -1;
                                            queue.offer(new int[]{newX,newY});
                                        }
                            }
                        }
                        step++;
                    }
                }
        return 0;
    }
    //深度优先遍历一座岛的范围
    void dfs(int[][] grid,Queue<int[]> queue,int x,int y){
        if (x >= 0 && x < grid.length)
            if (y >= 0 && y < grid.length)
                if (grid[x][y] == 1){
                    grid[x][y] = -1;
                    queue.offer(new int[]{x,y});
                    dfs(grid,queue,x-1,y);
                    dfs(grid,queue,x,y+1);
                    dfs(grid,queue,x+1,y);
                    dfs(grid,queue,x,y-1);
                }
    }
}
