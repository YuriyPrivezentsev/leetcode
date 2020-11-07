package nov_20_challange.nov06;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        if (sum <= threshold) {
            return 1;
        }
        if (threshold <= nums.length) {
            return max;
        }

        int mediana = mediana(min, max), counter = 0, result = Integer.MAX_VALUE, maxIterations = max;

        while (mediana != min && mediana != max && counter < maxIterations) {
            sum = 0;
            for (int num : nums) {
                sum += divRoundUp(num, mediana);
            }
            if (sum <= threshold) {
                if (result > mediana) {
                    result = mediana;
                }
                max = mediana;
                mediana = mediana(min, max);
            } else {
                min = mediana;
                mediana = mediana(min, max);
            }
            counter++;
        }
        return result;
    }

    private static int mediana(int min, int max) {
        return (min + max) / 2;
    }

    private static long divRoundUp(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }
}

