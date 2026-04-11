class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] palDp = new Boolean[n][n];
        int max = 0;
        String maxStr = new String();

        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++) {
                if(gap == 0) {
                    palDp[i][j] = true;
                    if(palDp[i][j]) {
                        int len = j - i;
                        if (max <= len) {
                            max = len;
                            maxStr = s.substring(i, j+1);
                        }
                    }
                }
                else if(gap == 1) {
                    palDp[i][j] = s.charAt(i) == s.charAt(j);
                    if(palDp[i][j]) {
                        int len = j - i;
                        if (max <= len) {
                            max = len;
                            maxStr = s.substring(i, j+1);
                        }
                    }
                }
                else {
                    palDp[i][j] = (s.charAt(i) == s.charAt(j)) && palDp[i+1][j-1];
                    if(palDp[i][j]) {
                        int len = j - i;
                        if (max <= len) {
                            max = len;
                            maxStr = s.substring(i, j+1);
                        }
                    }
                }
            }
        }
        return maxStr;
    }
}