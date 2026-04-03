class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        /*
        * s1 + s1 = tS and s1 - s2 = diff i.e. 2 * s1 = tS + diff => s1 = (tS + diff) / 2
        */
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];
        sum = sum+target; // this should be even
        if(sum%2 != 0) return 0;

        return solve(nums, sum/2, n);
    }

    private int solve(int[] nums, int sum, int n) {

        if(n == 0) return (sum == 0) ? 1 : 0;

        if(nums[n-1] <= sum) {
            return solve(nums, sum-nums[n-1], n-1) + solve(nums, sum, n-1);
        } else {
            return solve(nums, sum, n-1);
        }
    }
}