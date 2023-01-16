package me.decentos.leetcode.binarysearch;

public class H4MedianArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = merge(nums1, nums2);
        int mid = res.length / 2;
        if (res.length % 2 == 0) {
            int median = res[mid] + res[mid - 1];
            return (double) median / 2;
        } else {
            return res[mid];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[i + j] = nums1[i];
                i++;
            } else {
                res[i + j] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            res[i + j] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            res[i + j] = nums2[j];
            j++;
        }
        return res;
    }
}
