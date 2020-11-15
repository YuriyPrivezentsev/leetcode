package nov_20_challange.nov14;

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int numberOfAttempts = (minutesToTest / minutesToDie) + 1;
        double pigs = (Math.log(buckets) / Math.log(numberOfAttempts));

        return (int) Math.ceil(pigs);
    }
}
