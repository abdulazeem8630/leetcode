public class Solution {
    public int reverseDegree(String s) {
        int totalDegree = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int revAlphabetPos = 26 - (c - 'a');
            int stringPos = i + 1;
            totalDegree += revAlphabetPos * stringPos;
        }
        return totalDegree;
    }
}
