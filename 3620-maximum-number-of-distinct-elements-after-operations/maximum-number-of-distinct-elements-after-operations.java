class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int prev = Integer.MIN_VALUE;

        for (int x : nums) {
            int l = Math.max(x - k, prev + 1);
            if (l <= x + k) {
                prev = l;
                ans++;
            }
        }
        return ans;
    }
}