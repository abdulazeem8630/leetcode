import java.util.HashSet;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int totalArea = 0;
        HashSet<String> set = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];

            totalArea += (x2 - x1) * (y2 - y1);

            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            String p1 = x1 + " " + y1; // Bottom-left
            String p2 = x1 + " " + y2; // Top-left
            String p3 = x2 + " " + y1; // Bottom-right
            String p4 = x2 + " " + y2; // Top-right

            updateSet(set, p1);
            updateSet(set, p2);
            updateSet(set, p3);
            updateSet(set, p4);
        }

        if (set.size() != 4 || 
            !set.contains(minX + " " + minY) || 
            !set.contains(minX + " " + maxY) || 
            !set.contains(maxX + " " + minY) || 
            !set.contains(maxX + " " + maxY)) {
            return false;
        }

        int expectedArea = (maxX - minX) * (maxY - minY);
        return totalArea == expectedArea;
    }

    private void updateSet(HashSet<String> set, String point) {
        if (!set.add(point)) {
            set.remove(point);
        }
    }
}
