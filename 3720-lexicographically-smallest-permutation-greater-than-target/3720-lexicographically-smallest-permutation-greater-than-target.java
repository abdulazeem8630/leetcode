import java.util.Arrays;

public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        char[] result = new char[n];
        if (dfs(0, true, count, target, result)) {
            return new String(result);
        }
        
        return "";
    }
    
    private boolean dfs(int index, boolean isStrictlyEqual, int[] count, String target, char[] result) {
        if (index == target.length()) {
            return !isStrictlyEqual; 
        }
        
        if (isStrictlyEqual) {
            int targetCharIdx = target.charAt(index) - 'a';
            
            if (count[targetCharIdx] > 0) {
                result[index] = target.charAt(index);
                count[targetCharIdx]--;
                
                if (dfs(index + 1, true, count, target, result)) {
                    return true;
                }
                
                count[targetCharIdx]++;
            }
            
            for (int i = targetCharIdx + 1; i < 26; i++) {
                if (count[i] > 0) {
                    result[index] = (char) ('a' + i);
                    count[i]--;
                    
                    fillSmallest(index + 1, count, result);
                    return true;
                }
            }
            
        } else {
            fillSmallest(index, count, result);
            return true;
        }
        
        return false;
    }
    
    private void fillSmallest(int startIdx, int[] count, char[] result) {
        int charIdx = 0;
        for (int i = startIdx; i < result.length; i++) {
            while (count[charIdx] == 0) {
                charIdx++;
            }
            result[i] = (char) ('a' + charIdx);
            count[charIdx]--;
        }
    }
}
