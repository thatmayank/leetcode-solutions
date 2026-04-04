class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        Integer[][] dp = new Integer[n1+1][n2+1];
        return solve(text1, text2, n1, n2, dp);
    }

    private int solve(String text1, String text2, int n1, int n2, Integer[][] dp) {

        if(n1 == 0 || n2 == 0) return 0;
        if(dp[n1][n2] != null) return dp[n1][n2];

        if(text1.charAt(n1 - 1) == text2.charAt(n2 - 1)) {
            return dp[n1][n2] = 1 + solve(text1, text2, n1 - 1, n2 - 1, dp);
        } else {
            return dp[n1][n2] = Math.max(
                solve(text1, text2, n1 - 1, n2, dp), 
                solve(text1, text2, n1, n2 - 1, dp)
            );
        }
    }
}