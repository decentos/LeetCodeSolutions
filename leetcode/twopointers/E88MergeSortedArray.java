package twopointers;

public class E88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                result[index] = nums1[p1];
                p1++;
            } else {
                result[index] = nums2[p2];
                p2++;
            }
            index++;
        }
        while (p1 < m) {
            result[index] = nums1[p1];
            p1++;
            index++;
        }
        while (p2 < n) {
            result[index] = nums2[p2];
            p2++;
            index++;
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) break;

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            if (p1 >= 0 && p2 >= 0) {
                nums1[p] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            } else if (p1 >= 0) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
