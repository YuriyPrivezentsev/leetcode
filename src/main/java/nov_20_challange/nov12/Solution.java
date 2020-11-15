package nov_20_challange.nov12;

import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int num : nums) {
            result = addPermutation(result,num);
        }
        return new ArrayList<>(result);
    }

    Set<List<Integer>> addPermutation(Set<List<Integer>> list, int number){
        Set<List<Integer>> result = new HashSet<>();
        if(list.size() == 0){
            List<Integer> sublist = new ArrayList<>(1);
            sublist.add(number);
            result.add(sublist);
            return result;
        }
        for (List<Integer> sublist : list) {
            for(int i = 0; i <=  sublist.size(); i++){
                List<Integer> permutation = new LinkedList<>(sublist);
                permutation.add(i, number);
                result.add(permutation);
            }
        }
        return result;
    }

}
