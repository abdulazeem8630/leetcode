class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int rightNeeded = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                rightNeeded += 2;
                if (rightNeeded % 2 != 0) {
                    insertions++;
                    rightNeeded--;
                }
            } else {
                rightNeeded--;
                if (rightNeeded < 0) {
                    insertions++;
                    rightNeeded += 2;
                }
            }
        }
        
        return insertions + rightNeeded;
    }
}
