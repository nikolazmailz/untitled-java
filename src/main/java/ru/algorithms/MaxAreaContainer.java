package ru.algorithms;

public class MaxAreaContainer {
    public static int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, height * width);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + maxArea(heights)); // Output: 49
    }
}
