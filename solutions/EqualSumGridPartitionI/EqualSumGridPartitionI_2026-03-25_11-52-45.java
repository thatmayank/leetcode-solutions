class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long totalSum = 0;
        long prefixSum = 0;

        //check total sum
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                totalSum += grid[i][j];
            }
        }

        if(totalSum % 2 == 1) return false;

        //check for rows
        for(int i = 0; i < n; i++) {
            long rowSum = 0;
            for(int j = 0; j < m; j++) {
                rowSum += grid[i][j];
            }
            prefixSum += rowSum;
            if(totalSum/2 == prefixSum) return true;
        }

        //check for columns
        prefixSum = 0;
        for(int j = 0; j < m; j++) {
            long colSum = 0;
            for(int i = 0; i < n; i++) {
                colSum += grid[i][j];
            }
            prefixSum += colSum;
            if(totalSum/2 == prefixSum) return true;
        }

        return false;
    }
}