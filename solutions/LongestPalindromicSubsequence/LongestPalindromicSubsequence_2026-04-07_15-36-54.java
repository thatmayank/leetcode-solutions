    /*
    🔹 Longest Palindromic Subsequence (LPS)

    Two standard approaches:

    1️⃣ Convert to LCS:
       - Reverse the string → r
       - Find LCS(s, r)
       - Result = LPS length

    2️⃣ Direct DP on substring (preferred):

       Idea:
       - Work on substring s[i...j]
       - Compare characters at both ends

       Cases:
       ✔ If s[i] == s[j]
           → Include both characters
           → dp[i][j] = 2 + dp[i+1][j-1]

       ✔ If s[i] != s[j]
           → Skip one character
           → dp[i][j] = max(dp[i+1][j], dp[i][j-1])

       Base Cases:
       ✔ If i == j → single character → return 1
       ✔ If i > j → empty substring → return 0

       Notes:
       - Each match contributes +2 (pair of chars)
       - Middle character (odd length palindrome) contributes +1
       - Example: "bbabcbcab" → LPS = "babcbab" (length = 7)

       Initial Call:
       → solve(0, n-1)

       Time Complexity: O(n²)
       Space Complexity: O(n²)
    */

class Solution {

    /* Bottom up DP
    public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for(int i = 0; i < n; i++) dp[i][i] = 1;

    for(int i = n - 1; i >= 0; i--) {
        for(int j = i + 1; j < n; j++) {

            if(s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 2 + dp[i+1][j-1];
            } else {
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
    }

    return dp[0][n-1];
}
*/

    /* -- Recursive + Memo */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer dp[][] = new Integer[n+1][n+1];
        return solve(s, 0, n-1, dp);
    }

    private int solve(String s, int i, int j, Integer[][] dp) {

        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i+1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s, i+1, j, dp), solve(s, i, j-1, dp));
        }
    }

}