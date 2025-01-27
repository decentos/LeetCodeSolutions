package binarysearch;

public class H4MedianArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        int mid = merged.length / 2;

        if (merged.length % 2 == 0) {
            return (merged[mid] + merged[mid -1]) / 2.0;
        } else {
            return merged[mid];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] merged = new int[n1 + n2];
        int insetIndex = 0, i1 = 0, i2 = 0;

        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] < nums2[i2]) {
                merged[insetIndex++] = nums1[i1++];
            } else {
                merged[insetIndex++] = nums2[i2++];
            }
        }

        while (i1 < n1) {
            merged[insetIndex++] = nums1[i1++];
        }

        while (i2 < n2) {
            merged[insetIndex++] = nums2[i2++];
        }

        return merged;
    }
}
