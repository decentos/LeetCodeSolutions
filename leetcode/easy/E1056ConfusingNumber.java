package easy;

public class E1056ConfusingNumber {

    public boolean confusingNumber(int n) {
        int original = n, rotated = 0;

        while (original > 0) {
            int curr = original % 10;
            if (curr == 2 || curr == 3 || curr == 4 || curr == 5 || curr == 7) return false;

            int reversed = switch (curr) {
                case 6 -> 9;
                case 9 -> 6;
                default -> curr;
            };

            rotated = rotated * 10 + reversed;
            original /= 10;
        }
        return rotated != n;
    }
}
