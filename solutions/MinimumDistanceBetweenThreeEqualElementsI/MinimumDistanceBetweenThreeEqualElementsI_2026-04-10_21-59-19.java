class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> count = new HashMap<>();

        for(int i = 0; i < n; i++) {
            count.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            List<Integer> curr = count.get(nums[i]);
            if(curr.size() >= 3) {
                for(int j = 2; j < curr.size(); j++) {
                    int dist = Math.abs(curr.get(j-2) - curr.get(j-1))
                             + Math.abs(curr.get(j-1) - curr.get(j))
                             + Math.abs(curr.get(j) - curr.get(j-2));
                    min = Math.min(min, dist);
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}