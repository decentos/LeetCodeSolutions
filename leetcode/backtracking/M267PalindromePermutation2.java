package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M267PalindromePermutation2 {

    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);
        int count = 0;
        for (int val : map.values()) count += val % 2;
        if (count > 1) return Collections.emptyList();

        String single = "";
        if (count == 1) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 == 1) {
                    single += entry.getKey();
                    break;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        generate(ans, map, new StringBuilder(), s.length() / 2, single);
        return ans;
    }

    private void generate(List<String> ans, Map<Character, Integer> map, StringBuilder sb, int length, String single) {
        if (sb.length() == length) {
            ans.add(sb + single + new StringBuilder(sb).reverse());
            return;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= 1) continue;

            sb.append(entry.getKey());
            map.replace(entry.getKey(), entry.getValue() - 2);
            generate(ans, map, sb, length, single);
            map.replace(entry.getKey(), entry.getValue() + 2);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
