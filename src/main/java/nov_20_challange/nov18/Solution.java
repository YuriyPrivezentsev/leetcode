package nov_20_challange.nov18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public int[][] merge(int[][] intervals) {
        int [][] result = intervals;
        int length;
        do{
            length = result.length;
            result = internalMerge(result);
        } while (result.length != length);

        return result;
    }

    private int[][] internalMerge(int[][] intervals) {

        int[][] result = new int[intervals.length][];
        int resultCount = 0;
        for (int[] interval : intervals) {
            boolean merged = false;
            for (int i = 0; i < resultCount; i++) {
                int[] res = result[i];
                int[] merge = merge(res, interval);
                if(merge != null){
                    result[i] = merge;
                    merged = true;
                } else {
                    merge = merge(interval, res);
                    if(merge != null){
                        result[i] = merge;
                        merged = true;
                    }
                }
            }
            if(!merged){
                result[resultCount] = interval;
                resultCount++;
            }
        }
        return Arrays.copyOf(result,resultCount);
  }

    private int [] merge(int[] arr1, int[] arr2){
        if(arr1 == null || arr2 == null){
            return null;
        }
        if(inRange(arr2[0], arr1)){
            return new int[] {arr1 [0], Math.max(arr1[1], arr2[1])};
        }
        if (inRange(arr2[1], arr1)){
            return new int[] {Math.min(arr1[0], arr2[0]), arr1[1]};
        }
        return null;
    }

    private boolean inRange(int number, int[] range) {
        return number >= range[0] && number <= range[1];
    }
}
