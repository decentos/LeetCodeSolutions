package easy;

public class E27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == val) {
                while (nums[r] == val) r--;
                if (l > r) break;
                int right = nums[r];
                nums[r] = nums[l];
                nums[l] = right;
                r--;
            }
            l++;
        }
        return l;
    }

    public int removeElement2(int[] nums, int val) {
        int l = 0, r = nums.length;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r - 1];
                r--;
            } else {
                l++;
            }
        }
        return r;
    }
}
