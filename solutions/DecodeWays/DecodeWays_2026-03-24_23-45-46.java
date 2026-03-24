class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(s, 0, dp);
    }

    private int solve(String s, int i, Integer[] dp) {

        /*
        * 0 is invalid;
        * 1 to 26 : cases for single decoding: should not be 0
        * cases for double characters decoding: should start with 1 || should start with 2 and 2nd char be less than 7
        */

        if(i == s.length()) return 1; //Valid string decoding
        if(s.charAt(i) == '0') return 0; //Invalid

        if(dp[i] != null) return dp[i];

        int single_char = solve(s, i+1, dp);
        int double_char = 0;

        if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
            double_char = solve(s, i+2, dp);
        }

        dp[i] = single_char + double_char;
        return dp[i];
    }
}