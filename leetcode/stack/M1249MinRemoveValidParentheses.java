package stack;

import java.util.Stack;

public class M1249MinRemoveValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> openIndexes = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!openIndexes.isEmpty() && curr == ')') {
                int insertIndex = openIndexes.pop();
                ans.insert(insertIndex, '(').append(curr);
            } else if (curr == '(') {
                openIndexes.push(ans.length());
            } else if (curr != ')') {
                ans.append(curr);
            }
        }
        return ans.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        StringBuilder cleanClose = new StringBuilder();
        int openCount = 0, acceptClose = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
                acceptClose++;
            } else if (c == ')' && acceptClose > 0) {
                acceptClose--;
            } else if (c == ')' && acceptClose == 0) {
                continue;
            }
            cleanClose.append(c);
        }

        StringBuilder cleanOpen = new StringBuilder();
        int acceptOpen = openCount - acceptClose;
        for (int i = 0; i < cleanClose.length(); i++) {
            char curr = cleanClose.charAt(i);
            if (curr == '(' && acceptOpen > 0) {
                acceptOpen--;
            } else if (curr == '(' && acceptOpen == 0) {
                continue;
            }
            cleanOpen.append(curr);
        }
        return cleanOpen.toString();
    }
}
