class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int val = nums[i];

            mp.putIfAbsent(val, new int[]{-1,-1,-1});
            int[] arr = mp.get(val);

            arr[0] = arr[1]; // i
            arr[1] = arr[2]; // j
            arr[2] = i;      // k

            // Tuple found
            if(arr[0] != -1) {
                int dist = Math.abs(arr[0]-arr[1]) 
                         + Math.abs(arr[1]-arr[2]) 
                         + Math.abs(arr[2]-arr[0]);
                min = Math.min(min, dist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}