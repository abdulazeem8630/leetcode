import java.util.*;

class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftPart = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightPart = diffWaysToCompute(expression.substring(i + 1));
                for (int left : leftPart) {
                    for (int right : rightPart) {
                        if (c == '+') {
                            res.add(left + right);
                        } else if (c == '-') {
                            res.add(left - right);
                        } else if (c == '*') {
                            res.add(left * right);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        memo.put(expression, res);
        return res;
    }
}
