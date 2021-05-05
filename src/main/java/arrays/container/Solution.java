package arrays.container;
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        int leftPole = height[left], rightPole = height[right];
        int area = Math.min(leftPole,rightPole) * (right-left);
        while(left != right ){
            if(leftPole > rightPole){
                while(rightPole >= height[right] && right > left){
                    right--;
                }
                rightPole = height[right];
                area = Math.max(area, Math.min(leftPole,rightPole) * (right-left));
            } else {
                while(leftPole >= height[left] && right > left) {
                    left++;
                }
                leftPole = height[left];
                area = Math.max(area, Math.min(leftPole,rightPole) * (right-left));
            }
        }

        return area;
    }
}