class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        for (int x : nums1) {
            if (x % 2 != 0) {
                if (x < minOdd) {
                    minOdd = x;
                }
            }
        }
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }
        for (int x : nums1) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }
        return true;
    }
}
