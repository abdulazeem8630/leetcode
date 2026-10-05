import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() > starStack.peek()) {
                return false;
            }
            openStack.pop();
            starStack.pop();
        }
        
        return openStack.isEmpty();
    }
}
