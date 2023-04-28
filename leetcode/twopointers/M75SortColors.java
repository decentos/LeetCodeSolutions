package twopointers;

public class M75SortColors {

    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public void sortColors2(int[] nums) {
        int l = 0, r = nums.length - 1, curr = 0;
        while (curr <= r) {
            if (nums[curr] == 0) {
                int temp = nums[l];
                nums[l] = 0;
                nums[curr] = temp;
                l++;
                curr++;
            } else if (nums[curr] == 2) {
                int temp = nums[r];
                nums[r] = 2;
                nums[curr] = temp;
                r--;
            } else {
                curr++;
            }
        }
    }
}
