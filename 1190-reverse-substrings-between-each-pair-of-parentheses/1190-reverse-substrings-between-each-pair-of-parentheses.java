import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        int d = 1;
        
        while (curr < n) {
            if (s.charAt(curr) == '(' || s.charAt(curr) == ')') {
                curr = pair[curr];
                d = -d;
            } else {
                sb.append(s.charAt(curr));
            }
            curr += d;
        }
        
        return sb.toString();
    }
}
