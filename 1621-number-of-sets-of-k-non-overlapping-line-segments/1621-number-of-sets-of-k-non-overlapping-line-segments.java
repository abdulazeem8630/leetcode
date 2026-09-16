class Solution {
    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int R = 2 * k;
        if (R > N) return 0;
        
        int[] dp = new int[R + 1];
        dp[0] = 1;
        int MOD = 1000000007;
        
        for (int i = 1; i <= N; i++) {
            for (int j = Math.min(i, R); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        
        return dp[R];
    }
}
