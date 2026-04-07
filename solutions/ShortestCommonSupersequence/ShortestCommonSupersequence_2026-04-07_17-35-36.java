class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0; i < n1+1; i++) dp[i][0] = 0;
        for(int i = 0; i < n2+1; i++) dp[0][i] = 0;

        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {

                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n1;
        int j = n2;
        while(i > 0 && j > 0) {

            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            } 
            else if(dp[i-1][j] >= dp[i][j-1]) i--;
            else j--;
        }

        // Create SCS
        StringBuilder scs = new StringBuilder();
        i = 0;
        j = 0;
        for(int k = lcs.length()-1; k >= 0; k--) {
            char c = lcs.charAt(k);

            while(i < n1 && str1.charAt(i) != c) {
                scs.append(str1.charAt(i));
                i++;
            }

            while(j < n2 && str2.charAt(j) != c) {
                scs.append(str2.charAt(j));
                j++;
            }

            scs.append(c);
            i++;
            j++;
        }

        if(i < n1) scs.append(str1.substring(i));
        if(j < n2) scs.append(str2.substring(j));

        return scs.toString();
    }
}