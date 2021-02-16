package nov_20_challange.nov16;

class Solution {
    public int longestMountain(int[] A) {
        boolean isAscending = false, isDescending = false;
        int ascending = 0, descending = 0, previous = -1;
        int result = 0;

        for (int number : A) {
            if (previous == -1) {
                previous = number;
                continue;
            }

            if (previous == number) {
                if (isDescending) {
                    result = getResult(ascending, descending, result);
                }
                isAscending = false;
                ascending = 0;
                isDescending = false;
                descending = 0;
                continue;
            }

            if (previous < number) {
                if (isDescending) {
                    isAscending = true;
                    isDescending = false;
                    result = getResult(ascending, descending, result);
                    ascending = 1;
                    descending = 0;
                    previous = number;
                    continue;
                }
                isAscending = true;
                ascending++;
                previous = number;
                continue;
            }

            if (isAscending) {
                isAscending = false;
                isDescending = true;
                ascending++;
                descending = 1;
                previous = number;
                continue;
            }
            isDescending = true;
            descending++;
            previous = number;
        }

        return getResult(ascending, descending, result);
    }

    private int getResult(int ascending, int descending, int result) {
        return ascending != 0 && descending != 0 ? Math.max(result, ascending + descending) : result;
    }
}
