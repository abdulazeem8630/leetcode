class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        long upperBound = (long) Math.pow(10, n) - 1;
        long lowerBound = (long) Math.pow(10, n - 1);

        for (long leftHalf = upperBound; leftHalf >= lowerBound; leftHalf--) {
            long palindrome = createPalindrome(leftHalf);

            for (long factor1 = upperBound; factor1 * factor1 >= palindrome; factor1--) {
                if (palindrome % factor1 == 0) {
                    long factor2 = palindrome / factor1;
                    if (factor2 >= lowerBound && factor2 <= upperBound) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return 0;
    }

    private long createPalindrome(long leftHalf) {
        StringBuilder sb = new StringBuilder(String.valueOf(leftHalf));
        String reversed = sb.reverse().toString();
        return Long.parseLong(leftHalf + reversed);
    }
}
