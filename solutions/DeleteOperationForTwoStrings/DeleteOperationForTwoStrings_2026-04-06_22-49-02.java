class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int lcs = solve(word1, word2, n1, n2);
        return n1 + n2 - (2 * lcs);
    }

    private int solve(String word1, String word2, int n1, int n2) {
        Integer[][] dp = new Integer[n1+1][n2+1];

        for(int i = 0; i < n1+1; i++) dp[i][0] = 0;
        for(int i = 0; i < n2+1; i++) dp[0][i] = 0;

        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {

                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}