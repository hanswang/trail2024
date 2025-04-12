package me.hansw.fy24.solver;

public class FinderSolver {

    public boolean isPartOfIsland(char[][] M, int x, int y) {
        int row = M.length;
        int col = M[0].length;

        return (x >= 0) && (x < row) && (y >= 0) && (y < col) && (M[x][y] == '1');
    }

    public void DFS(char[][] M, int i, int j, boolean[][] visited) {
        // anchor based on position coordinates i & j to recursively DFS
        visited[i][j] = true;

        // loop through all the surrounding 8 cells
        int[] x_axis = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y_axis = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int x = x_axis[k] + i;
            int y = y_axis[k] + j;

            // check if picked coordinates within bound
            if (isPartOfIsland(M, x, y) && !visited[x][y]) {
                DFS(M, x, y, visited);
            }
        }

    }

    public int countIslands(char[][] M) {
        int row = M.length;
        int col = M[0].length;

        // define a separate boolean matrix for tracking the visit on DFS
        boolean[][] visited = new boolean[row][col];

        // traverse
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // if picked cell is "1", and haven't been visited, mark the new island
                if (M[i][j] == '1' && !visited[i][j]) {
                    // visit all adjacent cells
                    DFS(M, i, j, visited);

                    // confirm the islands count bump by 1
                    count++;
                }
            }
        }
        return count;
    }
}
