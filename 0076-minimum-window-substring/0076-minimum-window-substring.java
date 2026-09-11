import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int have = 0, need = tMap.size();
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(tMap.get(c))) {
                    have++;
                }
            }

            while (have == need) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char leftChar = s.charAt(l);
                if (tMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(tMap.get(leftChar))) {
                        have--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                l++;
            }
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
