import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        long left = 1;
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        long right = minCoin * k;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (countAmounts(mid, coins, n) >= k) {
                ans = mid;       
                right = mid - 1;  
            } else {
                left = mid + 1; 
            }
        }
        
        return ans;
    }

    private long countAmounts(long target, int[] coins, int n) {
        long totalCount = 0;
        int totalSubsets = 1 << n;

        for (int mask = 1; mask < totalSubsets; mask++) {
            long currentLcm = 1;
            int elementCount = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    elementCount++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    
                    if (currentLcm > target) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) continue;

            if (elementCount % 2 == 1) {
                totalCount += (target / currentLcm);
            } else {
                totalCount -= (target / currentLcm);
            }
        }

        return totalCount;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
