package easy;

public class E1295EvenNumberDigits {

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i : nums) {
            int count = 0;
            while (i != 0) {
                i /= 10;
                count++;
            }
            if (count % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public int findNumbers2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num > 9 && num < 100) || (num > 999 && num < 10000) || num == 100000) {
                count++;
            }
        }
        return count;
    }
}
