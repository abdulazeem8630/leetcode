class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int maxDiff = 0;
        
        // Find the maximum potential difference to size the bucket array
        for (int i = 0; i < nums1.length; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums1[i] - nums2[i]));
        }
        
        // If max difference is already 0, the sum of squared differences is 0
        if (maxDiff == 0) {
            return 0;
        }
        
        // Create a frequency array to track counts of each difference
        int[] bucket = new int[maxDiff + 1];
        for (int i = 0; i < nums1.length; i++) {
            bucket[Math.abs(nums1[i] - nums2[i])]++;
        }
        
        // Walk down from the maximum difference to flatten the peaks
        for (int d = maxDiff; d > 0; d--) {
            if (bucket[d] > 0) {
                // Determine how many elements at this difference level we can reduce
                long take = Math.min(k, bucket[d]);
                bucket[d] -= take;
                bucket[d - 1] += take;
                k -= take;
                
                if (k == 0) {
                    break;
                }
            }
        }
        
        // Compute the final sum of squared differences
        long minSquaredSum = 0;
        for (long d = 1; d <= maxDiff; d++) {
            if (bucket[(int) d] > 0) {
                minSquaredSum += bucket[(int) d] * d * d;
            }
        }
        
        return minSquaredSum;
    }
}
