package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E496NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int n = nums1.length;
        int[] greaters = new int[n];
        Arrays.fill(greaters, -1);

        for (int i = 0; i < n; i++) {
            int curr = nums1[i];
            int next = map.get(curr) + 1;
            for (int j = next; j < nums2.length; j++) {
                if (nums2[j] > curr) {
                    greaters[i] = nums2[j];
                    break;
                }
            }
        }
        return greaters;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) map.put(stack.pop(), num);
            stack.push(num);
        }

        int n = nums1.length;
        int[] greaters = new int[n];
        for (int i = 0; i < n; i++) {
            greaters[i] = map.getOrDefault(nums1[i], -1);
        }
        return greaters;
    }
}
