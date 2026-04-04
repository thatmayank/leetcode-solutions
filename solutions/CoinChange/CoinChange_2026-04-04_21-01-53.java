class Solution {
    int INF = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer dp[][] = new Integer[n+1][amount+1];
        int ans = solve(coins, amount, n, dp);
        return ans == INF ? -1 : ans;
    }

    private int solve(int[] coins, int amount, int n, Integer dp[][]) {

        if(amount == 0) return 0;
        if(n == 0 && amount > 0) return INF;
        if(dp[n][amount] != null) return dp[n][amount];

        if(coins[n-1] <= amount) {
            return dp[n][amount] = Math.min(
                1 + solve(coins, amount-coins[n-1], n, dp), 
                solve(coins, amount, n-1, dp)
            );
        } else {
            return dp[n][amount] = solve(coins, amount, n-1, dp);
        }
    }
}