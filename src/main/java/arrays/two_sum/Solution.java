package arrays.two_sum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            result[0] = i;
            int lookup = target - nums[i];
            for (int j = i+1; j < nums.length; j++){
                if(nums[j] == lookup){
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("No result found");
    }
}