package easy;

public class E1716CalculateMoney {

    public int totalMoney(int n) {
        int amount = 0, fullWeeks = n / 7, leftDays = n % 7;

        for (int week = 0; week < fullWeeks; week++) {
            amount += 28 + 7 * week;
        }
        amount += leftDays * (leftDays + 1) / 2 + leftDays * fullWeeks;

        return amount;
    }
}
