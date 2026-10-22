class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        boolean isInc = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero + i - 1) % n;
            int curr = (zero + i) % n;
            if (nums[prev] > nums[curr]) {
                isInc = false;
                break;
            }
        }
        if (isInc) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        boolean isDec = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero - (i - 1) + n) % n;
            int curr = (zero - i + n) % n;
            if (nums[prev] > nums[curr]) {
                isDec = false;
                break;
            }
        }
        if (isDec) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
