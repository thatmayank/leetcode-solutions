class Solution {
    int INF = (int) 1e9;
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] dp = new Integer[m+1][n+1][k+1];

        int ans = solve(grid, k, m-1, n-1, dp);
        return (ans == -INF) ? -1 : ans;
    }

    private int solve(int[][] grid, int k, int i, int j, Integer[][][] dp) {

        if(i < 0 || j < 0 || k < 0) return -INF;
        if(i == 0 && j == 0) return 0;
        if(dp[i][j][k] != null) return dp[i][j][k];

        int cost = (grid[i][j] == 0) ? 0 : 1;
        int newCost = k - cost;

        int max = Math.max(
            solve(grid, newCost, i-1, j, dp),
            solve(grid, newCost, i, j-1, dp)
        );

        return dp[i][j][k] = (max == -INF) ? -INF : max + grid[i][j];
    }
}