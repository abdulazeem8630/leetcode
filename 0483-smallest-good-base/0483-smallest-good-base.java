class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        
        for (int m = (int)(Math.log(num) / Math.log(2)); m >= 2; m--) {
            long k = (long) Math.pow(num, 1.0 / m);
            if (k < 2) continue;
            
            long sum = 0;
            long current = 1;
            boolean valid = true;
            
            for (int i = 0; i <= m; i++) {
                sum += current;
                if (i < m) {
                    if (num / k < current) {
                        valid = false;
                        break;
                    }
                    current *= k;
                }
            }
            
            if (valid && sum == num) {
                return String.valueOf(k);
            }
        }
        
        return String.valueOf(num - 1);
    }
}
