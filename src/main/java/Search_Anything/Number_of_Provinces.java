package Search_Anything;

public class Number_of_Provinces {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method findCircleNum：查询所有的省份数  dfs：递归调用函数
     * @param int[][] isConnected：城市相连数组  Boolean[] mark：是否已经访问过的标志
     * @return provinceNum：最终的省份数量
     * @Address https://leetcode.cn/problems/number-of-provinces/
     * @TitleName 547. 省份数量
     */
    public int findCircleNum(int[][] isConnected) {
        //城市的数量 n 以及初始省份的数量 0
        int n = isConnected.length;
        int provinceNum = 0;
        //标记数组，对已经访问过的省份标记为 true
        Boolean[] mark = new Boolean[n];
        for (int i = 0;i < n;i++)
            mark[i] = false;
        //循环遍历各个城市的相邻城市
        for (int i = 0;i < n;i++){
            //当前城市没有被访问过的时候才允许调用相关递归函数
            if (!mark[i]){
                dfs(isConnected,i,mark);
                provinceNum++;
            }
        }
        return  provinceNum;
    }

    public void dfs(int[][] isConnected,int i,Boolean[] mark){
        //数组的长度 n
        int n = isConnected.length;
        //将当前访问的城市置为 true，表示已经访问过
        mark[i] = true;
        for (int j = 0;j < n;j++){
            //如果发现该城市与某一城市相邻
            //在某一城市没有被访问的前提下，同样需要调用递归函数对某一城市进行访问
            if (isConnected[i][j] == 1 && !mark[j])
                dfs(isConnected,j,mark);
        }
    }
}
