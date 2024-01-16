package arrays.duplicates_easy;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int i = 0 ,j = 0, k = 1;
        for(;j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
                k++;
            }
        }
        return k;
    }

}
