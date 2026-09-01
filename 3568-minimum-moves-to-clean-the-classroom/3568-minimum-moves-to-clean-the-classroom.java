import java.util.*;

public class Solution {
    private static class State {
        int r, c, energy, mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] grid, int energy) {
        int m = grid.length;
        int n = grid[0].length();
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m * n][energy + 1][targetMask + 1];

        queue.offer(new State(startR, startC, energy, 0));
        visited[startR * n + startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State curr = queue.poll();

                if (curr.mask == targetMask) {
                    return moves;
                }

                if (curr.energy == 0 && grid[curr.r].charAt(curr.c) != 'R') {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr].charAt(nc) != 'X') {
                        int nextEnergy = curr.energy - 1;
                        int nextMask = curr.mask;
                        char nextChar = grid[nr].charAt(nc);

                        if (nextChar == 'R') {
                            nextEnergy = energy;
                        } else if (nextChar == 'L') {
                            nextMask |= (1 << litterId[nr][nc]);
                        }

                        if (nextEnergy >= 0 && !visited[nr * n + nc][nextEnergy][nextMask]) {
                            visited[nr * n + nc][nextEnergy][nextMask] = true;
                            queue.offer(new State(nr, nc, nextEnergy, nextMask));
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
