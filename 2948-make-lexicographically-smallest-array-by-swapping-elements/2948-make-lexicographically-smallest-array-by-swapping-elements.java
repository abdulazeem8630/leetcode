import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] sortedPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedPairs[i][0] = nums[i];
            sortedPairs[i][1] = i;
        }
        
        Arrays.sort(sortedPairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        
        while (i < n) {
            int j = i + 1;
            while (j < n && sortedPairs[j][0] - sortedPairs[j - 1][0] <= limit) {
                j++;
            }
            
            List<Integer> indices = new ArrayList<>();
            for (int k = i; k < j; k++) {
                indices.add(sortedPairs[k][1]);
            }
            
            Collections.sort(indices);
            
            for (int k = i; k < j; k++) {
                result[indices.get(k - i)] = sortedPairs[k][0];
            }
            
            i = j;
        }
        
        return result;
    }
}
