package twopointers;

public class E27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                nums[end--] = val;
            } else {
                start++;
            }
        }
        return start;
    }
}
