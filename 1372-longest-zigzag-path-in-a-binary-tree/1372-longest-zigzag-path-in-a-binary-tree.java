class Solution {
    private int maxPath = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxPath;
    }

    private void dfs(TreeNode node, boolean isLeft, int currentLength) {
        if (node == null) {
            return;
        }
        
        maxPath = Math.max(maxPath, currentLength);
        
        if (isLeft) {
            dfs(node.right, false, currentLength + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, currentLength + 1);
            dfs(node.right, false, 1);
        }
    }
}
