package medium;

public class M7ReverseInteger {

    public int reverse(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return x < 0 ? -1 * Integer.parseInt(reversed) : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        int reverse = 0, prev = 0;

        while (x != 0) {
            int next = x % 10;
            x /= 10;

            prev = reverse;
            reverse = reverse * 10 + next;
            if ((reverse - next) / 10 != prev) return 0;
        }
        return reverse;
    }
}
