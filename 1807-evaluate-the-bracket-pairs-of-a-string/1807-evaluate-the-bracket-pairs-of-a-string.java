import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inBracket = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                inBracket = true;
            } else if (ch == ')') {
                inBracket = false;
                String keyStr = key.toString();
                result.append(map.getOrDefault(keyStr, "?"));
                key.setLength(0);
            } else {
                if (inBracket) {
                    key.append(ch);
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
