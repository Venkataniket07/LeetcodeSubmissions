class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements.");
        }

        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int area = calculateArea(height, leftPointer, rightPointer);
            maxArea = Math.max(maxArea, area);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }

    private static int calculateArea(int[] height, int left, int right) {
        int width = right - left;
        int minHeight = Math.min(height[left], height[right]);
        return width * minHeight;
    }
}