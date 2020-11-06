package nov_20_challange.nov05;

class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for (int chipPosition : position) {
            if (chipPosition % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even,odd);
    }

}
