class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Ein Baum mit n Knoten MUSS genau n - 1 Kanten haben
        if (edges.length != n - 1) {
            return false;
        }

        // Graph als Adjazenzliste aufbauen
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // BFS: Knoten ab Knoten 0 besuchen
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited[0] = true;
        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visitedCount++;

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // Wenn wir alle n Knoten besuchen konnten, ist der Graph verbunden
        return visitedCount == n;
    }
}
