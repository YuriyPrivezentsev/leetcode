package arrays;

class MergeSorted {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int buffer = Integer.MAX_VALUE;
        boolean merge = true;
        int i = 0, j = 0;
        for(; i < m; i++){
            if (nums1[i] < buffer) {
                if(nums1 [i] >= nums2 [j] && merge){
                    buffer = nums1[i];
                    nums1[i] = nums2[j];
                    if(j < n - 1){
                        j++;
                    } else {
                        merge = false;
                    }
                }
            } else {
                int localBuffer = buffer;
                buffer = nums1[i];
                nums1[i] = localBuffer;
            }
        }
        if(!merge){
            if(buffer < Integer.MAX_VALUE) {
                nums1[i] = buffer;
            }
            return;
        }
        merge = buffer < Integer.MAX_VALUE;
        for(;j<n;i++){
            if(buffer <= nums2[j] && merge){
                nums1[i]=buffer;
                merge = false;
            } else {
                nums1[i] = nums2[j];
                j++;
            }
        }
    }

}
