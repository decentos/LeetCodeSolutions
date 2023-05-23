package string;

public class E1427PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        int n = s.length(), amount = 0;

        for (int[] direction : shift) {
            if (direction[0] == 0) {
                amount += direction[1];
            } else {
                amount -= direction[1];
            }
        }

        if (amount > 0) {
            amount = amount % n;
            return s.substring(amount) + s.substring(0, amount);
        } else {
            amount = Math.abs(amount) % n;
            return s.substring(n - amount) + s.substring(0, n - amount);
        }
    }
}
