package easy;

public class E2210CountHillsValleys {

    public int countHillValley(int[] nums) {
        int count = 0, prev = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int curr = nums[i], next = nums[i + 1];
            if ((prev < curr && curr > next) || (prev > curr && curr < next)) {
                count++;
                prev = curr;
            }
        }
        return count;
    }
}
