class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char mn = s.charAt(0);
        char mx = s.charAt(0);
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
            }
            if (s.charAt(i) < mn) {
                mn = s.charAt(i);
            }
            if (s.charAt(i) > mx) {
                mx = s.charAt(i);
            }
        }
        
        if (isSorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }
        
        return 3;
    }
}
