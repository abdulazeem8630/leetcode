import java.util.HashMap;
import java.util.Map;

class Solution {
    private int count = 0;
    private int target;
    private Map<Long, Integer> prefixSums = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        prefixSums.put(0L, 1);
        dfs(root, 0L);
        return count;
    }

    private void dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;
        count += prefixSums.getOrDefault(currentSum - target, 0);

        prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);

        dfs(node.left, currentSum);
        dfs(node.right, currentSum);

        prefixSums.put(currentSum, prefixSums.get(currentSum) - 1);
    }
}
