class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        if(m * n == 1) return 0;

        int[] arr = new int[m * n];
        int k = 0;
        int mod = grid[0][0] % x;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] % x != mod) return -1;
                arr[k] = grid[i][j];
                k++;
            }
        }

        Arrays.sort(arr);
        int sz = arr.length;

        int midA = arr[sz/2];
        int midB = arr[(sz/2) - 1];
        int opsA = 0;
        int opsB = 0;

        for(int i = 0; i < sz; i++) {
            opsA += (Math.abs(arr[i] - midA) / x);
            opsB += (Math.abs(arr[i] - midB) / x);
        }

        return Math.min(opsA, opsB);
    }
}