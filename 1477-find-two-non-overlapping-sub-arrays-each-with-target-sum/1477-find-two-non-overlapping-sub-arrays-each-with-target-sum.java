import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLeft = new int[n];
        for (int i = 0; i < n; i++) {
            minLeft[i] = Integer.MAX_VALUE;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;
        int currentMin = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
            
            if (map.containsKey(sum - target)) {
                int startIdx = map.get(sum - target);
                int len = i - startIdx;
                currentMin = Math.min(currentMin, len);
                
                if (startIdx >= 0 && minLeft[startIdx] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLeft[startIdx]);
                }
            }
            
            minLeft[i] = currentMin;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
