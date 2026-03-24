class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        /*
        * Flatten to 1D
        * Use prefix and postfix product
        * Calculate product matrix
        * construct 2D
        */

        int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;

        int[] arr = new int[n*m];
        int k = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[k] = grid[i][j];
                k++;
            }
        }

        k = arr.length;

        int[] prefix = new int[k]; prefix[0] = arr[0];
        int[] postfix = new int[k]; postfix[k-1] = arr[k-1];

        for(int i = 1; i < k; i++) {
            prefix[i] =(int) (((long)prefix[i-1] * arr[i]) % MOD);
            postfix[k-i-1] =(int) (((long)postfix[k-i] * arr[k-i-1]) % MOD);
        }

        arr[0] = postfix[1] % MOD;
        arr[k-1] = prefix[k-2] % MOD;

        for(int i = 1; i < k-1; i++) {
            arr[i] =(int) (((long)prefix[i-1] * postfix[i+1]) % MOD);
        }

        k = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = arr[k];
                k++;
            }
        }

        return grid;
    }
}