class Solution {
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        calculateSumAndCount(root);
        return count;
    }

    private int[] calculateSumAndCount(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = calculateSumAndCount(node.left);
        int[] right = calculateSumAndCount(node.right);

        int sum = left[0] + right[0] + node.val;
        int nodeCount = left[1] + right[1] + 1;

        if (sum / nodeCount == node.val) {
            count++;
        }

        return new int[]{sum, nodeCount};
    }
}
