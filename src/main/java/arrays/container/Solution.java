package arrays.container;
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = height.length - 1; j > i; j--) {
                int right = height[j];
                int rectHeight = Math.min(left, right);
                area = Math.max(area, rectHeight * (j-i));
            }
        }
        return area;
    }
}