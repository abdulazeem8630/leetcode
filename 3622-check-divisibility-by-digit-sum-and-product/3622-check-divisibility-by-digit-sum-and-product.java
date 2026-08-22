class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int digitSum = 0;
        int digitProduct = 1;
        
        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            digitProduct *= digit;
            n /= 10;
        }
        
        int totalSum = digitSum + digitProduct;
        
        if (totalSum == 0) {
            return false;
        }
        
        return original % totalSum == 0;
    }
}
