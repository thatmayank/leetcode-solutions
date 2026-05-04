class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;

        while(l <= r) {
            int mid = l + (r-l) / 2;

            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}