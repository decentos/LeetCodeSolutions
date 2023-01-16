package me.decentos.leetcode.easy;

public class E1299ReplaceElementsGreatest {

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            arr[i] = max;
            max = Math.max(max, curr);
        }
        return arr;
    }
}
