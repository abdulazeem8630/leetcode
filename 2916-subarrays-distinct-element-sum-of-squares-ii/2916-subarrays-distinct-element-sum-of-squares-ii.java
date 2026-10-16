import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] treeSum;
    private long[] treeSqSum;
    private int[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        treeSum = new long[4 * n];
        treeSqSum = new long[4 * n];
        lazy = new int[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;
        long currentWindowSum = 0;

        for (int i = 0; i < n; i++) {
            int prevIdx = lastSeen.getOrDefault(nums[i], -1);
            int startSegment = prevIdx + 1;
            int endSegment = i;

            update(0, 0, n - 1, startSegment, endSegment);
            
            currentWindowSum = (currentWindowSum + treeSqSum[0]) % MOD;
            totalSum = (totalSum + treeSqSum[0]) % MOD;
            
            lastSeen.put(nums[i], i);
        }

        return (int) totalSum;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0) return;
        
        int mid = start + (end - start) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        int val = lazy[node];

        apply(leftNode, start, mid, val);
        apply(rightNode, mid + 1, end, val);

        lazy[node] = 0;
    }

    private void apply(int node, int start, int end, int val) {
        long numElements = end - start + 1;
        
        treeSqSum[node] = (treeSqSum[node] + 2L * val * treeSum[node] % MOD + numElements * val % MOD * val % MOD) % MOD;
        treeSum[node] = (treeSum[node] + numElements * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            apply(node, start, end, 1);
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;

        if (l <= mid) {
            update(leftNode, start, mid, l, r);
        }
        if (r > mid) {
            update(rightNode, mid + 1, end, l, r);
        }

        treeSum[node] = (treeSum[leftNode] + treeSum[rightNode]) % MOD;
        treeSqSum[node] = (treeSqSum[leftNode] + treeSqSum[rightNode]) % MOD;
    }
}
