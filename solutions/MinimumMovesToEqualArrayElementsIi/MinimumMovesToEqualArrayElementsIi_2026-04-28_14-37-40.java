class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n/2];
        int ops = 0;

        for(int i = 0; i < n; i++) {
            ops += Math.abs(nums[i] - median);
        }
        return ops;
    }
}