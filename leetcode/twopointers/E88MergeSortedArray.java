package twopointers;

public class E88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (n < 0 || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }
}
