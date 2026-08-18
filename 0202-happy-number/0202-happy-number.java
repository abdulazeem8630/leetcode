class Solution {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n = n / 10;
        }
        return totalSum;
    }
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
            while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner); 
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
