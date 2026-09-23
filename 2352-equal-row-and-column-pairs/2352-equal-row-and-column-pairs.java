import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        Map<String, Integer> rowMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String rowStr = Arrays.toString(grid[i]);
            rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String colStr = Arrays.toString(col);
            count += rowMap.getOrDefault(colStr, 0);
        }

        return count;
    }
}
