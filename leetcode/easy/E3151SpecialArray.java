package easy;

public class E3151SpecialArray {

    public boolean isArraySpecial(int[] nums) {
        boolean isOdd = nums[0] % 2 == 1;

        for (int i = 1; i < nums.length; i++) {
            boolean isCurrOdd = nums[i] % 2 == 1;
            if (isOdd == isCurrOdd) {
                return false;
            }
            isOdd = !isOdd;
        }
        return true;
    }
}
