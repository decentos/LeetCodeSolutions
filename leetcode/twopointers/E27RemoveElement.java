package twopointers;

public class E27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            while (left <= right && nums[left] != val) left++;
            while (right >= left && nums[right] == val) right--;
            if (left > right) break;
            nums[left++] = nums[right--];
        }
        return left;
    }
}
