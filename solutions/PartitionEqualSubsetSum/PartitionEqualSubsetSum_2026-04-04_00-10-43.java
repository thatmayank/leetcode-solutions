class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];
        if(sum%2 != 0) return false;

        Boolean dp[][] = new Boolean[n+1][sum/2 + 1];
        return solve(nums, sum/2, n, dp);
    }

    private boolean solve(int[] nums, int sum, int n, Boolean dp[][]) {

        if(sum == 0) return true;
        if(n == 0) return false;
        if(dp[n][sum] != null) return dp[n][sum];

        if(nums[n-1] <= sum) {
            return dp[n][sum] = solve(nums, sum - nums[n-1], n-1, dp) || solve(nums, sum, n-1, dp);
        } else {
            return dp[n][sum] = solve(nums, sum, n-1, dp);
        }
    }
}