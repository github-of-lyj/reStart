package Search_Anything;

public class Surrounded_Regions {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method solve：找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * @param board：待填充矩阵
     * @return void
     * @Address https://leetcode.cn/problems/surrounded-regions/description/
     * @TitleName 130. 被围绕的区域
     */
    public void solve(char[][] board) {
        //待填充矩阵长度为 0，直接返回
        if (board.length == 0)
            return;
        //标记某一位置是否被 'X' 围绕
        boolean[][] notSiege = new boolean[board.length][board[0].length];
        //对边界上的元素采取 DFS 优先遍历
        //若为 '0',与其相连的元素必然不可能被 ‘X’ 围绕，将对应位置的 notSiege 设置为 true
        for (int i = 0;i < board.length;i++)
            for (int j = 0;j < board[0].length;j++){
                if (i == 0 || i == board.length-1)
                    dfs(board,i,j,notSiege);
                if (j == 0 || j == board[0].length-1)
                    dfs(board,i,j,notSiege);
            }
        //根据更新过的 siegeMark 对原矩阵进行填充
        for (int i = 0;i < board.length;i++)
            for (int j = 0;j < board[0].length;j++)
                if (notSiege[i][j])
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
    }

    void dfs(char[][] board,int i,int j,boolean[][] siegeMark){
        //确认位置是否合法
        if (i >= 0 && i < board.length)
            if (j >= 0 && j < board[0].length)
                if (board[i][j] == 'O'){
                    //修改对应位置的字符是为了确保不会无限递归导致栈溢出
                    board[i][j] = 'X';
                    siegeMark[i][j] = true;
                    dfs(board,i - 1, j,siegeMark);
                    dfs(board,i,j + 1,siegeMark);
                    dfs(board,i + 1,j,siegeMark);
                    dfs(board,i,j - 1,siegeMark);
                }
    }
}
