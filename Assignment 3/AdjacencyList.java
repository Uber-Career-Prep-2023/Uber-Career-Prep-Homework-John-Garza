import java.util.*;

public class AdjacencyList {
    public Map<Integer, Set<Integer>> adjacencySet(int[][] edges) {
        if (edges == null) {
            return null;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            addEdge(edge, graph);
        }
        return graph;
    }

    private void addEdge(int[] edge, Map<Integer, Set<Integer>> graph) {
        int src = edge[0];
        int dest = edge[1];

        Set<Integer> outEdges = graph.computeIfAbsent(src, k -> new HashSet<>());
        outEdges.add(dest);
    }

    public boolean bfs(int target, Map<Integer, Set<Integer>> graph) {
        if (graph == null) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        for (int src : graph.keySet()) {
            Queue<Integer> queue = new LinkedList<>();
            visited.add(src);
            queue.offer(src);
            while (!queue.isEmpty()) {
                int from = queue.poll();
                if (from == target) {
                    return true;
                }
                // if doesn't connect to rest of graph then
                if (!graph.containsKey(from)) {
                    continue;
                }
                for (int to : graph.get(from)) {
                    if (!visited.contains(to)) {
                        visited.add(to);
                        queue.offer(to);
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int target, Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        for (int src : graph.keySet()) {
            if (dfsHelper(target, graph, visited, src)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsHelper(int target, Map<Integer, Set<Integer>> graph, Set<Integer> visited, int cur) {
        if (cur == target) {
            return true;
        }
        visited.add(cur);
        for (int to : graph.get(cur)) {
            if (!visited.contains(to)) {
                dfsHelper(target, graph, visited, to);
            }
        }
        return false;
    }

    public List<Integer> topologicalSort(Map<Integer, Set<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int src : graph.keySet()) {
            if (!visited.contains(src)) {
                topoSortUtil(src, visited, stack, graph);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void topoSortUtil(int cur, Set<Integer> visited, Stack<Integer> stack, Map<Integer, Set<Integer>> graph) {
        visited.add(cur);
        if (graph.containsKey(cur)) {
            for (int neighbor : graph.get(cur)) {
                if (!visited.contains(neighbor)) {
                    topoSortUtil(neighbor, visited, stack, graph);
                }
            }
        }
        stack.push(cur);
    }
}