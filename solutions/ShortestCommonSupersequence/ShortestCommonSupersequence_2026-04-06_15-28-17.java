class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        Integer[][] dp = new Integer[n1+1][n2+1];
        
        for(int i = 0; i < n1+1; i++) dp[i][0] = 0;
        for(int i = 0; i < n2+1; i++) dp[0][i] = 0;
        
        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {
                
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // SCS = Length pf s1 + length of s2 - Length of LCS
        int scsLen = n1+n2-dp[n1][n2];
        
        /*
        * To find SCS : FIND LCS and append remaining charaters from strings to result string 
        * And then LCS to result string
        */
        StringBuilder lcs = new StringBuilder();
        int i = n1, j = n2;
        while(i > 0 && j > 0) {

            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                lcs.append(s1.charAt(i-1));
                i--;
                j--;
            } 
            else if(dp[i-1][j] >= dp[i][j-1]) i--;
            else j--;
        }

        StringBuilder scs = new StringBuilder();
        i = 0;
        j = 0;
        char[] lcsArray = lcs.reverse().toString().toCharArray();

        for(char c : lcsArray) {
            while(i < n1 && s1.charAt(i) != c) {
                scs.append(s1.charAt(i));
                i++;
            }
            while(j < n2 && s2.charAt(j) != c) {
                scs.append(s2.charAt(j));
                j++;
            }
            scs.append(s1.charAt(i));
            i++;
            j++;
        }

        if(i < n1) scs.append(s1.substring(i));
        if(j < n2) scs.append(s2.substring(j));
        
        return scs.toString();
    }
}