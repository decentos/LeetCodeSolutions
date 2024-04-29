package bit;

public class M2997MinNumberXORToK {

    public int minOperations(int[] nums, int k) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return Integer.bitCount(result ^ k);
    }
}
