package string;

public class E1614MaxDepthParentheses {

    public int maxDepth(String s) {
        int currOpens = 0, maxOpens = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currOpens++;
                maxOpens = Math.max(maxOpens, currOpens);
            } else if (c == ')') {
                currOpens--;
            }
        }
        return maxOpens;
    }
}
