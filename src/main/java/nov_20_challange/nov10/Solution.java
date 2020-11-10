package nov_20_challange.nov10;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            for (int forward = 0, backward = row.length - 1; forward <= backward; forward++, backward--) {
                int left = row[forward] ^ 1;
                int right = row[backward] ^ 1;
                row[forward] = right;
                row[backward] = left;
            }
        }
        return A;
    }


}
