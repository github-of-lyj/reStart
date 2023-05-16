package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一个区间的集合 intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/non-overlapping-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        /*
         * @author 林英杰
         * @since JDK 版本 1.8++
         * @Method eraseOverlapIntervals
         * @param  int[][] intervals
         * @return int total
         */
        if (intervals.length == 1 || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int total = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] < pre)
                total++;
            else
                pre = intervals[i][1];
        return total;
    }
}
