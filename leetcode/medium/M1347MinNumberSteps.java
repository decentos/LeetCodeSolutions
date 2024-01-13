package medium;

public class M1347MinNumberSteps {

    public int minSteps(String s, String t) {
        int diff = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            diff += Math.max(0, i);
        }
        return diff;
    }
}
