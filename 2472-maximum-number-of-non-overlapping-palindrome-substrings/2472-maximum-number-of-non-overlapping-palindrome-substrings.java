class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            
            for (int j = 0; j < 2; j++) {
                int l = i;
                int r = i + j;
                
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    int len = r - l + 1;
                    if (len >= k) {
                        dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                        break;
                    }
                    l--;
                    r++;
                }
            }
        }
        
        return dp[n];
    }
}
