class Solution {
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return calculate(1, n, memo);
    }
    
    private int calculate(int start, int end, int[][] memo) {
        if (start >= end) {
            return 0;
        }
        
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        
        int minCost = Integer.MAX_VALUE;

        for (int i = (start + end) / 2; i <= end; i++) {
            int leftCost = calculate(start, i - 1, memo);
            int rightCost = calculate(i + 1, end, memo);
            
            int worstCaseCost = i + Math.max(leftCost, rightCost);
            
            minCost = Math.min(minCost, worstCaseCost);
        }
        
        memo[start][end] = minCost;
        return minCost;
    }
}
