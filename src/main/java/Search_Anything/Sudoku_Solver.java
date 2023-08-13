package Search_Anything;

import java.util.Arrays;

public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        boolean[][] rowMark = new boolean[board.length][board[0].length];
        boolean[][] columnMark = new boolean[board.length][board[0].length];
        boolean[][] boxMark = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length;i++)
            for (int j = 0;j < board.length;j++){
                if (board[i][j] != '.'){
                    int curNum = Integer.parseInt(String.valueOf(board[i][j]));
                    int box_x = i / 3,box_y = j / 3;
                    rowMark[i][curNum-1] = true;
                    columnMark[j][curNum-1] = true;
                    boxMark[3*box_x + box_y][curNum-1] = true;
                }
            }
        System.out.println(Arrays.deepToString(rowMark));
        System.out.println(Arrays.deepToString(columnMark));
        System.out.println(Arrays.deepToString(boxMark));
        solveSudoByBack(board,rowMark,columnMark,boxMark,0,0);

    }
    void solveSudoByBack(char[][] board,boolean[][] rowMark,boolean[][] columnMark,boolean[][] boxMark,int i,int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (board[i][j] == '.'){
            for (int k = 1;k <= 9;k++){
                if (rowMark[i][k-1] || columnMark[j][k-1] || boxMark[2*i/3+j/3][k-1])
                    continue;
                rowMark[i][k-1] =  columnMark[j][k-1] = boxMark[3*(i/3)+j/3][k-1] = true;
                board[i][j] = Character.forDigit(k,10);
                solveSudoByBack(board,rowMark,columnMark,boxMark,i - 1,j);
                solveSudoByBack(board,rowMark,columnMark,boxMark,i,j + 1);
                solveSudoByBack(board,rowMark,columnMark,boxMark,i + 1,j);
                solveSudoByBack(board,rowMark,columnMark,boxMark,i,j - 1);
                rowMark[i][k-1] =  columnMark[j][k-1] = boxMark[3*(i/3)+j/3][k-1] = false;
                board[i][j] = '.';
            }
        }
    }
}
