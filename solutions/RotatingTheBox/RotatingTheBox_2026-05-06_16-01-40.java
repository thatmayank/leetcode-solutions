class Solution {
    int m, n;

    public char[][] rotateTheBox(char[][] boxGrid) {
        m = boxGrid.length;
        n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int r = n - 1; r >= 0; r--) {
                if (boxGrid[i][r] == '.') {
                    int l = r - 1;
                    while (l >= 0 && boxGrid[i][l] != '#' && boxGrid[i][l] != '*')
                        l--;
                    if (l >= 0) {
                        if (boxGrid[i][l] == '#') {
                            boxGrid[i][r] = '#';
                            boxGrid[i][l] = '.';
                            l--;
                        }
                    }
                }
            }
        }

        return rotateMatrix(boxGrid);
    }

    private char[][] rotateMatrix(char[][] boxGrid) {
        char[][] res = new char[n][m];

        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = boxGrid[j][i];
            }
        }

        //Reverse Y axis
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l < r) {
                char temp = res[i][l];
                res[i][l] = res[i][r];
                res[i][r] = temp;
                l++;
                r--;
            }
        }

        return res;
    }
}