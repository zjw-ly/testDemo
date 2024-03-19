package com.example.demo.leetcode.types.backtrace;

/**
 * 单词搜索
 * <p>
 * [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
 * <p>
 * ["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]
 *
 * @author zaochun.zjw
 * @date 2024/3/15
 */
public class Medium79单词搜索 {

    public static void main(String[] args) {
        Medium79单词搜索 tmp = new Medium79单词搜索();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};

        //  char[][] board = new char[][]{{'a'}};
        System.out.println(tmp.exist(board, "ABCB"));
    }

    boolean verify = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] mark = new boolean[board.length][board[0].length];
                dfs(board, mark, i, j, word, 0);
                if (verify) {
                    return verify;
                }
            }
        }

        return false;
    }

    public void dfs(char[][] board, boolean[][] mark, int hang, int lie, String word, int index) {
        if (!verifyInLine(board, hang, lie) || mark[hang][lie]) {
            return;
        }

        if (board[hang][lie] != word.charAt(index)) {
            return;
        }

        index++;
        if (index == word.length()) {
            verify = true;
            return;
        }

        mark[hang][lie] = true;
        dfs(board, mark, hang + 1, lie, word, index);
        dfs(board, mark, hang - 1, lie, word, index);
        dfs(board, mark, hang, lie + 1, word, index);
        dfs(board, mark, hang, lie - 1, word, index);
        // 复原 撤销置位
        mark[hang][lie] = false;
    }

    public boolean verifyInLine(char[][] board, int hang, int lie) {
        return hang >= 0 && hang < board.length && lie >= 0 && lie < board[0].length;
    }
}
