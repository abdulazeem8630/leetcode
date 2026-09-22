import java.util.Arrays;

class Solution {
    private static class Node {
        int[] remain;
        int prod = 1;
        
        Node(int k) {
            remain = new int[k];
        }
    }

    private int n;
    private int k;
    private Node[] tree;

    private Node merge(Node left, Node right) {
        Node res = new Node(k);
        res.prod = (left.prod * right.prod) % k;
        for (int i = 0; i < k; i++) {
            res.remain[i] += left.remain[i];
            int nextMod = (left.prod * i) % k;
            res.remain[nextMod] += right.remain[i];
        }
        return res;
    }

    private void build(int[] nums, int cur, int left, int right) {
        if (left == right) {
            tree[cur] = new Node(k);
            tree[cur].remain[nums[left] % k] = 1;
            tree[cur].prod = nums[left] % k;
            return;
        }
        int mid = (left + right) / 2;
        build(nums, 2 * cur + 1, left, mid);
        build(nums, 2 * cur + 2, mid + 1, right);
        tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
    }

    private void update(int cur, int lo, int hi, int i, int val) {
        if (lo == hi) {
            Arrays.fill(tree[cur].remain, 0);
            tree[cur].remain[val % k] = 1;
            tree[cur].prod = val % k;
            return;
        }
        int mid = (lo + hi) / 2;
        if (i <= mid) {
            update(2 * cur + 1, lo, mid, i, val);
        } else {
            update(2 * cur + 2, mid + 1, hi, i, val);
        }
        tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
    }

    private Node query(int cur, int lo, int hi, int i, int j) {
        if (i <= lo && hi <= j) {
            return tree[cur];
        }
        int mid = (lo + hi) / 2;
        if (j <= mid) {
            return query(2 * cur + 1, lo, mid, i, j);
        }
        if (i > mid) {
            return query(2 * cur + 2, mid + 1, hi, i, j);
        }
        return merge(query(2 * cur + 1, lo, mid, i, j), query(2 * cur + 2, mid + 1, hi, i, j));
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];
        
        build(nums, 0, 0, n - 1);
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            
            update(0, 0, n - 1, index, value);
            
            if (start >= n) {
                result[i] = (x == 1) ? 1 : 0;
            } else {
                Node resNode = query(0, 0, n - 1, start, n - 1);
                result[i] = resNode.remain[x];
            }
        }
        
        return result;
    }
}
