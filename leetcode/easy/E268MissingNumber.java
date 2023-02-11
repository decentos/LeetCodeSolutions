package easy;

public class E268MissingNumber {

    public int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int i : nums) count[i]++;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) return i;
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int i : nums) actualSum += i;
        return expectedSum - actualSum;
    }
}
