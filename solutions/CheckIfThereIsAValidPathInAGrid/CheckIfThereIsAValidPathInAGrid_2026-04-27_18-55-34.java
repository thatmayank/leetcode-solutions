class Solution {
    int m, n;
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];

        return solve(0, 0, grid, isVisited);
    }

    private boolean solve(int i, int j, int[][] grid, boolean[][] isVisited) {
        
        if(i == m-1 && j == n-1) return true;
        if(isVisited[i][j]) return false;

        isVisited[i][j] = true;

        // for each cell there are two directions
        // need to traverse both directions
        // add condition if next cell allows the prev movement

        switch(grid[i][j]) {
            case 1 -> {
                return ((j-1 >= 0) 
                    && (grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 6) 
                    && solve(i, j-1, grid, isVisited))
                    || ((j+1 < n) 
                    && (grid[i][j+1] == 1 || grid[i][j+1] == 3 || grid[i][j+1] == 5) 
                    && solve(i, j+1, grid, isVisited));
            }
            case 2 -> {
                return ((i-1 >= 0) 
                    && (grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4) 
                    && solve(i-1, j, grid, isVisited)) 
                    || ((i+1 < m) 
                    && (grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6) 
                    && solve(i+1, j, grid, isVisited));
            }
            case 3 -> {
                return ((i+1 < m) 
                    && (grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6) 
                    && solve(i+1, j, grid, isVisited)) 
                    || ((j-1 >= 0) 
                    && (grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 5) 
                    && solve(i, j-1, grid, isVisited));
            }
            case 4 -> {
                return ((i+1 < m) 
                    && (grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6) 
                    && solve(i+1, j, grid, isVisited)) 
                    || ((j+1 < n) 
                    && (grid[i][j+1] == 1 || grid[i][j+1] == 3 || grid[i][j+1] == 5) 
                    && solve(i, j+1, grid, isVisited));
            }
            case 5 -> {
                return ((i-1 >= 0) 
                    && (grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4) 
                    && solve(i-1, j, grid, isVisited)) 
                    || ((j-1 >= 0) 
                    && (grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 6) 
                    && solve(i, j-1, grid, isVisited));
            }
            case 6 -> {
                return ((i-1 >= 0) 
                    && (grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4) 
                    && solve(i-1, j, grid, isVisited)) 
                    || ((j+1 < n) 
                    &&(grid[i][j+1] == 1 || grid[i][j+1] == 3 || grid[i][j+1] == 5) 
                    && solve(i, j+1, grid, isVisited));
            }
        }
        return false;
    }
}