class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        for (int i = 0; i < 4; i++) {
            if (check(grid))
                return true;
            grid = rotate(grid);
        }
        return false;
    }

    private boolean check(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long totalSum = 0, topSum = 0;
        Set<Long> cells = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                topSum += grid[i][j];
                cells.add((long) grid[i][j]);
            }
            long bottomSum = totalSum - topSum;
            long diff = topSum - bottomSum;

            if (diff == 0)
                return true;
            if (diff < 0)
                continue;

            if (grid[0][0] == diff)
                return true;
            if (grid[0][m - 1] == diff)
                return true;
            if (grid[i][0] == diff)
                return true;
            if (i > 0 && m > 1 && cells.contains(diff))
                return true;
        }

        return false;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = grid[i][j];
            }
        }

        return res;
    }
}
