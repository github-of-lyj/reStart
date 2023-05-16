package Greedy;

/*
假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，
能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/can-place-flowers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
         * @author 林英杰
         * @since JDK 版本 1.8++
         * @Method canPlaceFlowers
         * @param int[] flowerbed, int n
         * @return boolean
         */
        for (int i = 0; i < flowerbed.length; i++) {
            //要种的花的数量为0，直接返回
            if (n == 0)
                break;
            if (flowerbed[i] == 1)
                continue;
            //判断是否可以种花
            //i-1 < 0 表明左边没有东西 同理 i+1 > flowerbed.length - 1 表示右边没有东西
            //flowerbed[i] == 0 表示这里没有种花
            if (i - 1 < 0 || flowerbed[i - 1] == 0)
                if (i + 1 > flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            //能满足需求 直接break
            if (n == 0)
                break;
        }
        return n == 0;
    }

    public boolean canPlaceFlowersSecond(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
     /*
        作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode-solution-sojr/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */


}
