import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int maxGlobal = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                }
                String key = dy + "," + dx;
                slopeMap.put(key, slopeMap.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(key));
            }
            maxGlobal = Math.max(maxGlobal, localMax + 1);
        }
        return maxGlobal;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
