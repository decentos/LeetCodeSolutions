package easy;

public class E1134ArmstrongNumber {

    public boolean isArmstrong(int n) {
        int length = String.valueOf(n).length();
        int sum = 0, temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, length);
            temp /= 10;
        }
        return sum == n;
    }
}
