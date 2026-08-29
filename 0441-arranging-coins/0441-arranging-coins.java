class Solution {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long current = mid * (mid + 1) / 2;
            if (current == n) {
                return (int) mid;
            }
            if (n < current) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
