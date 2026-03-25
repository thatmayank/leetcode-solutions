class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] rowSum = new long[n];
        long[] colSum = new long[m];

        long totalSum = 0;
        long prefixSum = 0;

        //check total sum
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                totalSum += grid[i][j];
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        if(totalSum % 2 == 1) return false;

        //check for rows
        for(int i = 0; i < n; i++) {
            prefixSum += rowSum[i];
            if(totalSum/2 == prefixSum) return true;
        }

        //check for cols
        prefixSum = 0;
        for(int j = 0; j < m; j++) {
            prefixSum += colSum[j];
            if(totalSum/2 == prefixSum) return true;
        }

        return false;
    }
}