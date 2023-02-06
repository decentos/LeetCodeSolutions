package medium;

import java.util.ArrayList;
import java.util.List;

public class M93RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int l1 = Math.max(1, n - 9); l1 <= 3 && l1 <= n - 3; l1++) {
            String part1 = s.substring(0, l1);
            boolean isValid1 = isValid(s, 0, l1, part1);
            if (!isValid1) continue;

            for (int l2 = Math.max(1, n - l1 - 6); l2 <= 3 && l2 <= n - l1 - 2; l2++) {
                int end2 = l1 + l2;
                String part2 = s.substring(l1, end2);
                boolean isValid2 = isValid(s, l1, l2, part2);
                if (!isValid2) continue;

                for (int l3 = Math.max(1, n - l1 - l2 - 3); l3 <= 3 && l3 <= n - l1 - l2 - 1; l3++) {
                    int end3 = l1 + l2 + l3;
                    String part3 = s.substring(end2, end3);
                    String part4 = s.substring(end3);
                    boolean isValid3 = isValid(s, end2, l3, part3);
                    boolean isValid4 = isValid(s, end3, n - l1 - l2 - l3, part4);
                    if (!isValid3 || !isValid4) continue;

                    result.add(String.join(".", part1, part2, part3, part4));
                }
            }
        }
        return result;
    }

    private boolean isValid(String s, int start, int length, String part) {
        int ip = Integer.parseInt(part);
        return length == 1 || (s.charAt(start) != '0' && (length < 3 || ip <= 255));
    }
}
