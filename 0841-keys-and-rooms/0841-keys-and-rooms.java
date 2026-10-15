import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited[0] = true;
        int visitedCount = 1;
        
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    visitedCount++;
                    if (visitedCount == n) {
                        return true;
                    }
                    queue.add(key);
                }
            }
        }
        
        return visitedCount == n;
    }
}
