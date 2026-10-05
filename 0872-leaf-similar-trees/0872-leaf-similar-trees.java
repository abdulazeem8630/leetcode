import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        findLeaves(root1, leaves1);
        findLeaves(root2, leaves2);
        
        return leaves1.equals(leaves2);
    }
    
    private void findLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        findLeaves(node.left, leaves);
        findLeaves(node.right, leaves);
    }
}
