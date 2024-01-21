package arrays.three_sum;

import java.util.*;
import java.util.stream.Collectors;


class Solution {
    /*
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Set<Integer> processed = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int numI = nums[i];
                if (!processed.contains(numI)) {
                    Set<Integer> subProcessed = new HashSet<>();
                    for (int j = i + 1; j < nums.length; j++) {
                        int numJ = nums[j];
                        if (!subProcessed.contains(numJ)) {
                            int sum = numI + numJ;
                            for (int k = j + 1; k < nums.length; k++) {
                                int numK = nums[k];
                                sum += numK;
                                if (sum == 0) {
                                    List<Integer> triplet = Arrays.asList(numI, numJ, numK);
                                    Collections.sort(triplet);
                                    if(newSolution(results, triplet)) {
                                        results.add(triplet);
                                        processed.add(numI);
                                        subProcessed.add(numJ);
                                        break;
                                    }
                                }
                                sum -= numK;
                            }
                        }
                    }
                }
            }
            return results;
        }
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int numI = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int numJ = nums[j];
                    int sum = numI + numJ;
                    int k = Arrays.binarySearch(nums, j + 1, nums.length, -sum);
                    if (k > j && k < nums.length && nums[k] == -sum) {
                        List<Integer> triplet = Arrays.asList(numI, numJ, -sum);
                        Collections.sort(triplet);
                        results.add(triplet);
                    }
                }
        }
        return new ArrayList<>(results);
    }


    private boolean newSolution(Collection<List<Integer>> results, List<Integer> triplet) {
        for (List<Integer> result : results) {
            if (result.equals(triplet)) {
                return false;
            }
        }
        return true;
    }

}
