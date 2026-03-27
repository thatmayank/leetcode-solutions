class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        /*
        * if k%n == 0, no need to rotate => actual array
        * Left Rotate: 
        * 1. reverse elements from 0 to k-1
        * 2. reverse elements from k to n-1
        * 3. reverse whole array
        * Right Rotate:
        * 1. reverse whole array
        * 2. reverse elements from 0 to k-1
        * 3. reverse elemets from k to n-1
        */
        int m = mat.length, n = mat[0].length;
        k=k%n;
        if(k==0) return true;
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++) {
            if(i%2==0) res[i] = leftRotate(mat[i], n, k);
            else res[i] = rightRotate(mat[i], n, k);
        }

        if(check(mat, res, m, n)) return true;
        return false;
    }

    private int[] leftRotate(int[] mat, int n, int k) {
        int[] rotate = mat.clone();
        reverse(rotate, 0, k-1);
        reverse(rotate, k, n-1);
        reverse(rotate, 0, n-1);
        return rotate;
    }

    private int[] rightRotate(int[] mat, int n, int k) {
        int[] rotate = mat.clone();
        reverse(rotate, 0, n-1);
        reverse(rotate, 0, k-1);
        reverse(rotate, k, n-1);
        return rotate;
    }

    private void reverse(int[] rotate, int start, int end) {
        while(start < end) {
            int temp = rotate[start];
            rotate[start] = rotate[end];
            rotate[end] = temp;

            start++;
            end--;
        }
    }
    private boolean check(int[][] mat, int[][] res, int m, int n) {
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != res[i][j]) return false;
            }
        }
        return true;
    }
}