import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[31];
        long MOD = 1000000007;
        
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }
        
        long totalSumOfSquares = 0;
        
        for (int j = 0; j < k; j++) {
            long currentNum = 0;
            for (int i = 0; i < 31; i++) {
                if (bitCounts[i] > 0) {
                    currentNum |= (1L << i);
                    bitCounts[i]--;
                }
            }
            totalSumOfSquares = (totalSumOfSquares + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSumOfSquares;
    }
}
