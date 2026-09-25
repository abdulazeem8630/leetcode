import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(expression);
        Set<String> resultSet = new HashSet<>();

        while (!queue.isEmpty()) {
            String expr = queue.poll();

            if (expr.indexOf('{') == -1) {
                resultSet.add(expr);
                continue;
            }

            int i = 0;
            while (expr.charAt(i) != '}') {
                i++;
            }
            int right = i;

            int left = right;
            while (expr.charAt(left) != '{') {
                left--;
            }

            String before = expr.substring(0, left);
            String after = expr.substring(right + 1);
            String[] options = expr.substring(left + 1, right).split(",");

            for (String option : options) {
                StringBuilder sb = new StringBuilder();
                sb.append(before).append(option).append(after);
                queue.offer(sb.toString());
            }
        }

        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
