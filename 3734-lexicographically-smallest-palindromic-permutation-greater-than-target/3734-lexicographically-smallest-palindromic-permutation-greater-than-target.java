import java.util.Arrays;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        char[] halfCurrent = new char[halfLen];
        
        if (canFormValidPalindrome(halfCount, oddChar, target, halfCurrent, 0, true, halfLen, n)) {
            return buildPalindrome(halfCurrent, oddChar, n);
        }

        return "";
    }

    private boolean canFormValidPalindrome(int[] halfCount, int oddChar, String target, char[] halfCurrent, int idx, boolean isTight, int halfLen, int totalLen) {
        if (idx == halfLen) {
            if (isTight) {
                String fullPalindrome = buildPalindrome(halfCurrent, oddChar, totalLen);
                return fullPalindrome.compareTo(target) > 0;
            }
            return true;
        }

        int startChar = isTight ? (target.charAt(idx) - 'a') : 0;

        for (int i = startChar; i < 26; i++) {
            if (halfCount[i] > 0) {
                halfCount[i]--;
                halfCurrent[idx] = (char) ('a' + i);
                
                boolean nextTight = isTight && (i == startChar);
                if (canFormValidPalindrome(halfCount, oddChar, target, halfCurrent, idx + 1, nextTight, halfLen, totalLen)) {
                    return true;
                }
                
                halfCount[i]++;
            }
        }

        return false;
    }

    private String buildPalindrome(char[] half, int oddChar, int totalLen) {
        StringBuilder sb = new StringBuilder();
        sb.append(half);
        if (oddChar != -1) {
            sb.append((char) ('a' + oddChar));
        }
        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }
        return sb.toString();
    }
}
