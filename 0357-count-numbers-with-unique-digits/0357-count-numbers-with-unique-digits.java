class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int totalCount = 10;
        
        int uniqueDigitsProduct = 9;
        int availableChoices = 9;

        for (int i = 2; i <= n && availableChoices > 0; i++) {
            uniqueDigitsProduct *= availableChoices;
            totalCount += uniqueDigitsProduct;
            availableChoices--; 
        }

        return totalCount;
    }
}
