class Solution {
    private int m;
    private int n;
    private char[][] grid;
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        this.memo = new Boolean[m][n][(m + n) / 2 + 1];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int bal) {
        if (grid[r][c] == '(') {
            bal++;
        } else {
            bal--;
        }

        if (bal < 0 || bal > (m + n) / 2) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }

        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }

        boolean res = false;
        if (r + 1 < m) {
            res = res || dfs(r + 1, c, bal);
        }
        if (c + 1 < n) {
            res = res || dfs(r, c + 1, bal);
        }

        return memo[r][c][bal] = res;
    }
}
