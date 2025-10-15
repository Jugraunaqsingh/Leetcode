class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] can = new int[n]; // can[i] = length of increasing sequence starting at i
        can[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            can[i] = (nums.get(i) < nums.get(i + 1)) ? can[i + 1] + 1 : 1;
        }
        
        int low = 1, high = n / 2, ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean valid = false;
            for (int i = 0; i <= n - 2 * mid; i++) {
                if (can[i] >= mid && can[i + mid] >= mid) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}