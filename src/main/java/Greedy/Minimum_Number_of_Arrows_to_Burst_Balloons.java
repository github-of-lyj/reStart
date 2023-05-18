package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method findMinArrowShots:查找所需要的最小弓箭数量
     * @param int[][] points
     * @return int arrow
     */
    public static int findMinArrowShots(int[][] points) {
        //至少使用一支弓箭
        int arrow  = 1;
        //根据区间起始进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //定义覆盖区间
        int left = points[0][0],right = points[0][1];
        for (int i = 1; i < points.length;i++)
        {
            //根据情况修改覆盖区间，若可以划分到同一个覆盖区间，则一支箭就可以解决
            if (points[i][0] >= left && points[i][0] <= right)
            {
                left = points[i][0];
                if (points[i][1] <= right)
                    right = points[i][1];
            }
            //不能划分到覆盖区间，以下一个气球为基准，定义新的覆盖区间
            else {
                left = points[i][0];
                right = points[i][1];
                arrow++;
            }
        }
        return arrow;
    }
}
