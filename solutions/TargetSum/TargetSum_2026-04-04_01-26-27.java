class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        /*
        * s1 + s1 = tS and s1 - s2 = diff i.e. 2 * s1 = tS + diff => s1 = (tS + diff) / 2
        */
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];
        sum = sum+target; // this should be even
        if(sum < 0 || sum%2 != 0) return 0;
        Integer[][] dp = new Integer[n+1][sum/2 + 1];

        return solve(nums, sum/2, n, dp);
    }

    private int solve(int[] nums, int sum, int n, Integer[][] dp) {

        if(n == 0) return (sum == 0) ? 1 : 0;
        if(dp[n][sum] != null) return dp[n][sum];

        if(nums[n-1] <= sum) {
            return dp[n][sum] = solve(nums, sum-nums[n-1], n-1, dp) + solve(nums, sum, n-1, dp);
        } else {
            return dp[n][sum] = solve(nums, sum, n-1, dp);
        }
    }
}