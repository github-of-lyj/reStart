package Dynamic_Programming;

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        //初始堆给定数对链进行排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //dp[i][0] 表示考虑前面 i 个数对链所能得到的最大的数对链长度
        //dp[i][1] 表示组成最大数对链长度时尾部数对的下标
        int[][] dp = new int[pairs.length+1][2];
        //考虑前面 1 个数对链所能得到的最大的数对链长度为 1
        //此时组成最大数对链长度时尾部数对链的下标为 0
        dp[1][0] = 1;
        dp[1][1] = 0;
        for (int i = 2;i <= pairs.length;i++){
            //如果当前数对链的 c 比 组成最大数对链长度时尾部数对链的 b 还要大
            //认为可以组成更长的数对链
            //并且更新尾部数对链的下标
            if (pairs[i-1][0] > pairs[dp[i-1][1]][1]){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = i-1;
            }else {
                //否则认为无法组成更长的数对链
                //但是此时需要变换尾部数对链，将其变换为 b 更小的那一个
                //否则可能会因为 b 值过大而导致后续无法构成更大的数对链
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = pairs[i-1][1] < pairs[dp[i-1][1]][1] ? i-1 : dp[i-1][1];
            }
        }
        return dp[pairs.length][0];
    }
}
