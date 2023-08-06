package Search_Anything;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method solveNQueens：n皇后问题   BackNQueens：回溯法求解
     * @param int n：皇后的数量
     * @return List<List<String>> results：具体排列方式集合
     * @Address https://leetcode.cn/problems/n-queens/
     * @TitleName 51. N 皇后
     */
    //最终结果集合 results
    //当前某一种可能情况 oneResult
    List<List<String>> results = new ArrayList<>();
    List<String> oneResult = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //若皇后数量为 0，直接返回即可
        if (n == 0)
            return results;
        //构造初始棋盘（不放置皇后时候的状态）
        StringBuilder init = new StringBuilder();
        for (int i = 0;i < n;i++)
            init.append(".");
        for (int i = 0;i < n;i++)
            oneResult.add(String.valueOf(init));
        //三种标志数组：分别是
        //同列是否已经有皇后
        //左斜方是否已经有皇后
        //右斜方是否已经有皇后
        //因为是按照行来遍历，所以不考虑同行的情况
        Boolean[] columnMark = new Boolean[n];
        Boolean[] leftDev = new Boolean[2*n - 1];
        Boolean[] rightDev = new Boolean[2*n - 1];
        //同样是构建初始数组
        for (int i = 0;i < n;i++)
            columnMark[i] = false;
        for (int i = 0;i < 2*n-1;i++){
            leftDev[i] = false;
            rightDev[i] = false;
        }
        //回溯求解
        BackNQueens(columnMark,leftDev,rightDev,n,0);
        return results;
    }

    void BackNQueens(Boolean[] columnMark,Boolean[] leftDev,Boolean[] rightDev,int n,int row){
        //当 row == n 时，认为所有皇后都已经在合法的位置上，将当前结果添加到最终结果集合 results 中
        if (row == n){
            List<String> list = new ArrayList<>(oneResult);
            results.add(list);
            return;
        }
        //对各个位置尝试是否可以放置皇后
        for (int i = 0; i < n;i++){
            //如果位置不合法则考虑下一个位置
            if (columnMark[i] || leftDev[n-(row - i)-1] || rightDev[row + i])
                continue;
            //如果位置合法
            //将当前位置标记为已被占有
            //判断左斜方已经有皇后，则对于同一斜线上的皇后，此时 行号 - 列号 为一确定值，例如 0,0 1,1 2,2 3,3
            //判断右斜方已经有皇后，则对于同一斜线上的皇后，此时 行号 + 列号 为一确定值，例如 3,0 2,1 1,2 0,3
            columnMark[i] = leftDev[n-(row - i)-1] = rightDev[row + i] = true;
            //将当前行的当前位置设置为皇后所在的位置
            StringBuilder temp = new StringBuilder(oneResult.get(row));
            temp.setCharAt(i,'Q');
            oneResult.set(row, String.valueOf(temp));
            //考虑下一行的皇后所在的位置
            BackNQueens(columnMark,leftDev,rightDev,n,row + 1);
            //回溯~
            //将标记复原
            //将先前皇后占有的位置还原
            columnMark[i] = leftDev[n-(row - i)-1] = rightDev[row + i] = false;
            temp.setCharAt(i,'.');
            oneResult.set(row,String.valueOf(temp));
        }
    }

}
