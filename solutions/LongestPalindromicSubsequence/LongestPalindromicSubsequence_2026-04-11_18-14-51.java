class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String r = reverse(s.toCharArray(), n);
        Integer[][] dp = new Integer[n+1][n+1];
        return solve(s, r, n, n, dp);
    }
    
    private int solve(String s, String r, int i, int j, Integer[][] dp) {
        
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        
        if(s.charAt(i-1) == r.charAt(j-1)) {
            return dp[i][j] = 1 + solve(s, r, i-1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s, r, i-1, j, dp), solve(s, r, i, j-1, dp));
        }
    }
    
    private String reverse(char[] arr, int n) {
        int i = 0, j = n-1;
        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}