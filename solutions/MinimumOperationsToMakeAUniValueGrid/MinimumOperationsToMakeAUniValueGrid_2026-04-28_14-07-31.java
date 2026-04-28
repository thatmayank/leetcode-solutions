class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int k = 0;
        int mod = grid[0][0] % x;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] % x != mod) return -1;
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int mid = arr[arr.length/2];
        int ops = 0;

        for(int i = 0; i < arr.length; i++) {
            ops += (Math.abs(arr[i] - mid) / x);
        }

        return ops;
    }
}