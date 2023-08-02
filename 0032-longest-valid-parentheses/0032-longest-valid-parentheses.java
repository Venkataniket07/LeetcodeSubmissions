class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize the stack with -1

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (!stack.isEmpty()) {
                    // The top of the stack contains the index of the last unmatched '('
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // If the stack is empty, push the current index as the new starting point
                    stack.push(i);
                }
            }
        }

        return maxLength;
    }
}