import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        Arrays.sort(squares);
        
        long totalSum = 0;
        int minusSlots = n / 2;
        
        for (int i = 0; i < n; i++) {
            if (i < minusSlots) {
                totalSum -= squares[i];
            } else {
                totalSum += squares[i];
            }
        }
        
        return totalSum;
    }
}
