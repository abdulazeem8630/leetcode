class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest / minutesToDie;

        int states = rounds + 1;
        
        int pigs = 0;
        long currentBucketsCovered = 1;
        
        while (currentBucketsCovered < buckets) {
            currentBucketsCovered *= states;
            pigs++;
        }
        
        return pigs;
    }
}
