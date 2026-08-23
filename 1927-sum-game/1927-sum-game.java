class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQuestions = 0, rightQuestions = 0;
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (i < n / 2) {
                if (c == '?') {
                    leftQuestions++;
                } else {
                    leftSum += c - '0';
                }
            } else {
                if (c == '?') {
                    rightQuestions++;
                } else {
                    rightSum += c - '0';
                }
            }
        }
        int sumDiff = leftSum - rightSum;
        int qDiff = rightQuestions - leftQuestions;
        if (qDiff % 2 == 0 && (qDiff / 2) * 9 == sumDiff) {
            return false; 
        }

        return true;
    }
}
