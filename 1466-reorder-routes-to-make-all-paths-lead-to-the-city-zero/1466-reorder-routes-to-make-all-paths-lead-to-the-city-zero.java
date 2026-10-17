import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static class Edge {
        int to;
        int sign; 
        
        Edge(int to, int sign) {
            this.to = to;
            this.sign = sign;
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] c : connections) {
            adj.get(c[0]).add(new Edge(c[1], 1)); 
            adj.get(c[1]).add(new Edge(c[0], 0));
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited[0] = true;
        int changeCount = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Edge edge : adj.get(curr)) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    changeCount += edge.sign;
                    queue.add(edge.to);
                }
            }
        }
        
        return changeCount;
    }
}
