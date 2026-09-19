class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int totalSum = prefixSum[n - 1];
        
        for (int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = totalSum - prefixSum[i];
            
            if (leftSum == rightSum) {
                return i;
            }
        }
        
        return -1;
    }
}
