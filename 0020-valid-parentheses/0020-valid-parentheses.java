class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);

            else {
                if (st.isEmpty())
                    return false;
                char stack_top = st.pop();
                if ((ch == ')' && stack_top != '(') ||
                        (ch == '}' && stack_top != '{') ||
                        (ch == ']' && stack_top != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}