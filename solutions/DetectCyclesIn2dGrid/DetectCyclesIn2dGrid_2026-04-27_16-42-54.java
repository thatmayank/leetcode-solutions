class Solution {
    int m, n;
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(!isVisited[i][j] && checkCycle(i, j, i, j, grid, isVisited)) return true;
            }
        }
        return false;
    }

    private int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean checkCycle(int i, int j, int prev_i, int prev_j, char[][] grid, boolean[][] isVisited) {

        if(isVisited[i][j]) return true;

        isVisited[i][j] = true;

        for(int[] dir : dirs) {
            int curr_i = i + dir[0];
            int curr_j = j + dir[1];

            // check boundaries
            if(curr_i >= 0 && curr_i < m && curr_j >= 0 && curr_j < n) {

                if(curr_i == prev_i && curr_j == prev_j) continue;

                if(grid[i][j] == grid[curr_i][curr_j] && checkCycle(curr_i, curr_j, i, j, grid, isVisited)) {
                    return true;
                } 
            }
        }
        return false;

    }
}