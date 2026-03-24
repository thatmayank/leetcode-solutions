class Solution {
    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int MOD = 1_000_000_007;
        Long[][][] dp = new Long[row][col][2];

        long[] res = solve(row-1, col-1, grid, dp);
        return res[1] < 0 ? -1 : (int) (res[1] % MOD);
    }

    private long[] solve(int up, int left, int[][] grid, Long[][][] dp) {

        if(up == 0 && left == 0) return new long[]{grid[up][left], grid[up][left]};

        if(dp[up][left][0] != null) return new long[]{dp[up][left][0], dp[up][left][1]};
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        int val = grid[up][left];

        if(up > 0) {
            long[] upMinMax = solve(up-1, left, grid, dp);
            long upMin = upMinMax[0];
            long upMax = upMinMax[1];
            min = Math.min(min, Math.min(upMin * val, upMax * val));
            max = Math.max(max, Math.max(upMin * val, upMax * val));
        }

        if(left > 0) {
            long[] leftMinMax = solve(up, left-1, grid, dp);
            long leftMin = leftMinMax[0];
            long leftMax = leftMinMax[1];
            min = Math.min(min, Math.min(leftMin * val, leftMax * val));
            max = Math.max(max, Math.max(leftMin * val, leftMax * val));
        }

        dp[up][left][0] = min;
        dp[up][left][1] = max;
        return new long[]{min, max};

    }
}