class Solution {
    
    /* Using LCS */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        Integer[][] dp = new Integer[n+1][m+1];
        for(int i = 0; i < n+1; i++) dp[i][0] = 0;
        for(int i = 0; i < m+1; i++) dp[0][i] = 0;

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {

                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while(i > 0 && j > 0) {

            if(s.charAt(i-1) == t.charAt(j-1)) {
                lcs.append(s.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] >= dp[i][j-1]) i--;
            else j--;
        }

        if(n != lcs.length()) return false;

        i = 0;
        j = lcs.length()-1;
        while(i < n && j >= 0) {
            if(s.charAt(i) != lcs.charAt(j)) return false;
            i++;
            j--;
        }
        return true; 
    }


    /* Using Two Pointers
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;

        while(i < n && j < m) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        }

        if(i == n) return true;
        return false;
    }
    */
}