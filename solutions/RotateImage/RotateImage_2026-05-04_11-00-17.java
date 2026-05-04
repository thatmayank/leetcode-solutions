class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //Transpose
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        //Rotate on Y axis
        for(int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while(l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}


/*
1 2 3
4 5 6
7 8 9
Transpose
1 4 7
2 5 8
3 6 9
Rotate on Y axis
7 4 1
8 5 2
9 6 3
*/
