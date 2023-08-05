package Search_Anything;

public class Word_Search {
    boolean isExist = false;
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method exist：返回结果表明字符串单词 word 是否存在于二维字符网络 board 当中
     * @param char[][] board：二维字符网络  String word：待查找字符串单词
     * @return isExist：是否存在
     * @Address https://leetcode.cn/problems/word-search/
     * @TitleName 79. 单词搜索
     */
    public boolean exist(char[][] board, String word) {
        //m、n 分别为二维字符网络的行高以及列高
        int m = board.length, n = board[0].length;
        //防止重复查找的标记数组 mark，初始均为 false
        boolean[][] mark = new boolean[m][n];
        for (int i = 0;i < m;i++)
            for (int j = 0;j < n;j++)
                mark[i][j] = false;
        for (int i = 0;i < m;i++)
            for (int j = 0;j < n;j++)
                findWord(board,i,j,word,0,mark);
        return isExist;
    }

    void findWord(char[][] board,int x,int y,String word,int pos,boolean[][] mark){
        //越界情况直接返回
        if (x < 0 || x >= board.length)
            return;
        if (y < 0 || y >= board[0].length)
            return;
        //已访问过直接返回
        //已找到结果直接返回
        //字符不相等直接返回
        if (mark[x][y] || isExist || board[x][y] != word.charAt(pos))
            return;
        if (pos == word.length() - 1){
            isExist = true;
            return;
        }
        //设置标记为已访问
        mark[x][y] = true;
        findWord(board,x - 1,y,word,pos + 1,mark);
        findWord(board,x,y + 1,word,pos + 1,mark);
        findWord(board,x + 1,y,word,pos + 1,mark);
        findWord(board,x,y - 1,word,pos + 1,mark);
        //回溯修改标记
        mark[x][y] = false;
    }


}
