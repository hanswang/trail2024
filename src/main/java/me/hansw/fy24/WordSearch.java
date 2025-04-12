package me.hansw.fy24;

public class WordSearch {

    static boolean isWithinBoundingBox(char[][] board, int i, int j, boolean[][] visited) {
        int row = board.length;
        int col = board[0].length;

        return (i >= 0) && (i < row) && (j >= 0) && (j < col) && (!visited[i][j]);
    }

    static boolean DFS(char[][] board, int i, int j, String word, boolean[][] visited) {
        char[] targetChars = word.toCharArray();

        if (board[i][j] != targetChars[0]) {
            visited[i][j] = false;
            return false;
        }

        visited[i][j] = true;
        if (targetChars.length == 1) {
            return true;
        }

        int[] x_axis = {-1, 0, 0, 1};
        int[] y_axis = {0, 1, -1, 0};

        for (int k = 0; k < 4; k++) {
            int cord_x = i + x_axis[k];
            int cord_y = j + y_axis[k];

            if (isWithinBoundingBox(board, cord_x, cord_y, visited)) {
                String trailingWord = word.substring(1);
                if (DFS(board, cord_x, cord_y, trailingWord, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;

        return false;
    }

    static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];
        boolean found = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == word.charAt(0)) {
                    found = DFS(board, i, j, word, visited);
                }
                if (found) {
                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCESEEEFS";

        System.out.println("Result: " + exist(board, word));
    }
}
