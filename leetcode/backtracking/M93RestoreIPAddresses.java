package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M93RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int l1 = 1; l1 < n && l1 < 4; l1++) {
            String part1 = s.substring(0, l1);
            if (isNotValid(part1)) continue;

            for (int l2 = 1; l1 + l2 < n && l2 < 4; l2++) {
                String part2 = s.substring(l1, l1 + l2);
                if (isNotValid(part2)) continue;

                for (int l3 = 1; l1 + l2 + l3 < n && l3 < 4; l3++) {
                    String part3 = s.substring(l1 + l2, l1 + l2 + l3);
                    String part4 = s.substring(l1 + l2 + l3);
                    if (isNotValid(part3) || isNotValid(part4)) continue;

                    result.add(String.join(".", part1, part2, part3, part4));
                }
            }
        }
        return result;
    }

    private boolean isNotValid(String s) {
        if (s.length() > 3) return true;
        if (s.startsWith("0") && s.length() > 1) return true;
        return Integer.parseInt(s) > 255;
    }
}
