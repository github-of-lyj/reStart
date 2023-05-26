package Greedy;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method maxProfit(int[] prices)
     * @param int[] prices:价格数组
     * @return maxProfit：最大利润
     */
    public int maxProfit(int[] prices) {
        //价格数组的长度为空或为1，直接返回0，因为没有钱可以赚
        if(prices.length == 1 || prices.length == 0)
            return 0;
        //maxProfit：最大利润
        int maxProfit = 0;
        //currentMaxPrice：以当前股价为基准的逐日递增最大价格
        int currentMaxPrice = 0;
        //index：当前股的下标
        int index = 0;
        while(index != prices.length){
            //循环找出当前股的逐日递增最大价格
            for(int i = index+1; i < prices.length; i++){
                if(prices[i] > prices[i-1])
                    currentMaxPrice = i;
                else
                    break;
            }
            //更新相应的参数
            maxProfit = maxProfit + prices[currentMaxPrice] - prices[index];
            index = currentMaxPrice + 1;
            currentMaxPrice = index ;
        }
        return maxProfit;
    }
}
