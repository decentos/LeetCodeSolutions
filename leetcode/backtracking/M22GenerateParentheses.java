package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, new StringBuilder(), n, 0);
        return ans;
    }

    private void generate(List<String> ans, StringBuilder curr, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(curr.toString());
            return;
        }

        if (left > 0) {
            curr.append("(");
            generate(ans, curr, left - 1, right + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (right > 0) {
            curr.append(")");
            generate(ans, curr, left, right - 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
