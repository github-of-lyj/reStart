package Search_Anything;

import java.util.*;

public class Minimum_Height_Trees {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method findMinHeightTrees：寻找当根节点不同时数的最小高度
     * @param n：结点的数量  edges：边的集合
     * @return 根节点的集合 result
     * @Address  https://leetcode.cn/problems/minimum-height-trees/description/
     * @TitleName 310. 最小高度树
     */
    //广度优先搜索，但是超时
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //result 集合存放最终结果
        //perhaps 集合存放最终可能的结果集合
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> perhaps = new HashMap<>();
        //当前的最小数高
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0;i < n;i++){
            //当前结果是否已经被访问
            boolean[] isVisit = new boolean[n];
            //当前树的高度
            int curHeight = 0;
            //广度优先搜索队列
            Queue<Integer> Que = new ArrayDeque<>();
            Que.offer(i);
            //当队列不空时说明树还未遍历完成
            while (!Que.isEmpty()){
                //当前树高已经被找到的最小树高大，没有继续的必要
                if(curHeight > minHeight)
                    break;
                //限定每一轮的循环次数
                int curSize = Que.size();
                for (int j = 0;j < curSize;j++){
                    //弹出队首节点，并将其访问标志置为 true
                    int curRoot = Que.poll();
                    isVisit[curRoot] = true;
                    //将访问标志不为 true且与当前结点相连的结点添加进队列当中
                    for (int[] edge : edges) {
                        if (edge[0] == curRoot && !isVisit[edge[1]])
                            Que.offer(edge[1]);
                        else if (edge[1] == curRoot && !isVisit[edge[0]])
                            Que.offer(edge[0]);
                    }
                }
                //循环结束数的高度加一
                curHeight++;
            }
            if (curHeight < minHeight)
                minHeight = curHeight;
            //存放一种可能的结果
            perhaps.put(i,curHeight);
        }
        //将所有可能的结果放入 result 集合
        for (int i = 0;i < n;i++)
            if (perhaps.get(i) == minHeight)
                result.add(i);
        return result;
    }
}
