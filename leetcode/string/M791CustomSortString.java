package string;

public class M791CustomSortString {

    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : order.toCharArray()) {
            if (count[c - 'a'] > 0) {
                sb.append(String.valueOf(c).repeat(count[c - 'a']));
                count[c - 'a'] = 0;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                char c = (char) ('a' + i);
                sb.append(String.valueOf(c).repeat(count[i]));
            }
        }
        return sb.toString();
    }
}
