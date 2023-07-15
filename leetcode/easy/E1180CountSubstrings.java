package easy;

public class E1180CountSubstrings {

    public int countLetters(String s) {
        int sum = 0, n = s.length();
        int ptr = 0;

        while (ptr < n) {
            int count = 0;
            char curr = s.charAt(ptr);

            while (ptr < n && s.charAt(ptr) == curr) {
                count++;
                ptr++;
            }

            int currSum = (1 + count) * count / 2; // sum of arithmetic progression
            sum += currSum;
        }
        return sum;
    }

    public int countLetters2(String s) {
        int sum = 1, count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            sum += count;
        }
        return sum;
    }
}
