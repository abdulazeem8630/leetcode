import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0}); // {row, col, steps}
        maze[entrance[0]][entrance[1]] = '+'; // Mark entrance as visited
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int steps = current[2];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && maze[nr][nc] == '.') {
                    // Check if this cell is an exit (on the border)
                    if (nr == 0 || nr == rows - 1 || nc == 0 || nc == cols - 1) {
                        return steps + 1;
                    }
                    
                    maze[nr][nc] = '+'; // Mark as visited
                    queue.add(new int[]{nr, nc, steps + 1});
                }
            }
        }
        
        return -1;
    }
}
