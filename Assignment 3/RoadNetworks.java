
// Technique: Graph DFS
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
import java.util.*;

public class RoadNetworks {
    public static void main(String[] args) {
        String[] towns = { "Anchorage", "Skagway", "Juneau", "Gustavus", "Homer", "Port Alsworth",
                "Glacier Bay", "Fairbanks", "McCarthy", "Copper Center", "Healy" };
        String[][] roads = {
                { "Anchorage", "Homer" },
                { "Glacier Bay", "Gustavus" },
                { "Copper Center", "McCarthy" },
                { "Anchorage", "Copper Center" },
                { "Copper Center", "Fairbanks" },
                { "Healy", "Fairbanks" },
                { "Healy", "Anchorage" } };

        System.out.println(numNetworks(towns, roads));
    }

    public static int numNetworks(String[] towns, String[][] roads) {
        Map<String, Integer> strToIndex = buildGraph(towns);
        int vertices = strToIndex.size();
        List<Set<Integer>> adj = buildAdjList(roads, vertices, strToIndex);
        boolean[] visited = new boolean[vertices];
        int res = 0;

        for (int i = 0; i < vertices; i++) {
            if (visited[i] || adj.get(i).isEmpty()) {
                continue;
            }
            dfs(i, adj, visited);
            res++;
        }
        return res;
    }

    private static Map<String, Integer> buildGraph(String[] towns) {
        Map<String, Integer> result = new HashMap<>();
        for (String town : towns) {
            result.put(town, result.size());
        }
        return result;
    }

    private static List<Set<Integer>> buildAdjList(String[][] roads, int vertices, Map<String, Integer> strToIndex) {
        List<Set<Integer>> result = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            result.add(new HashSet<>());
        }
        for (String[] road : roads) {
            String town1 = road[0];
            String town2 = road[1];

            int index1 = strToIndex.get(town1);
            int index2 = strToIndex.get(town2);
            result.get(index1).add(index2);
        }
        return result;
    }

    private static void dfs(int i, List<Set<Integer>> adj, boolean[] visited) {
        if (visited[i])
            return;
        visited[i] = true;
        for (int neighbor : adj.get(i)) {
            dfs(neighbor, adj, visited);
        }
    }
}
// Time Taken: 30 mins