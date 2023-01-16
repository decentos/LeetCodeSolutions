package me.decentos.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class M658ClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr.length == k) {
            for (int i : arr) result.add(arr[i]);
            return result;
        }

        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) right = mid;
            else left = mid + 1;
        }

        right = left;
        left -= 1;

        while (right - left - 1 < k) {
            if (left == -1) {
                right++;
                continue;
            }

            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) left--;
            else right++;
        }

        for (int i = left + 1; i < right; i++) result.add(arr[i]);
        return result;
    }
}
