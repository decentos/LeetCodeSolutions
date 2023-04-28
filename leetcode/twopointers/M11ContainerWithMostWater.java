package twopointers;

public class M11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left <= right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int width = right - left;
            int area = width * Math.min(leftHeight, rightHeight);
            max = Math.max(max, area);

            if (leftHeight > rightHeight) right--;
            else left++;
        }
        return max;
    }
}
