class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        int i = 0, j = n/2;
        int pair = 0;
        Arrays.sort(nums);

        while(i < n/2 && j < n) {
            if(2 * nums[i] <= nums[j]) {
                pair++;
                i++;
                j++;
            } else {
                while(j < n && (long) 2 * nums[i] > nums[j]) j++;
            }
        }
        return 2 * pair;
    }
}