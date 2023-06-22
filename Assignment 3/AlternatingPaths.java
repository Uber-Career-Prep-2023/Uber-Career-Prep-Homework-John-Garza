
// Technique - BFS approach to find shortest path, Still unsure how to properly do
// Time Complexity - O(V+E) where V is number of vertices and E is number of edges
// Space Complexity - O(V) since using a queue to store vertices
import java.util.*;

public class AlternatingPaths {
    public static void main(String[] args) {
        String[][] edgearray = {
                { "A", "B", "blue" }, { "A", "C", "red" }, { "B", "D", "blue" }, { "B", "E", "blue" },
                { "C", "B", "red" }, { "D", "C", "blue" }, { "A", "D", "red" }, { "D", "E", "red" }, { "E", "C", "red" }
        };
        System.out.println(shortestAltPath("A", "E", edgearray));
        System.out.println(shortestAltPath("E", "D", edgearray));

    }

    public static int shortestAltPath(String origin, String destination, String[][] edges) {
        Map<String, List<List<String>>> adj = new HashMap<>();
        for (String[] strings : edges) {
            String src = strings[0];
            String dest = strings[1];
            String color = strings[2];
            adj.putIfAbsent(src, new ArrayList<>());
            List<String> pair = new ArrayList<>();
            pair.add(dest);
            pair.add(color);
            adj.get(src).add(pair);
        }
        Set<String[]> visited = new HashSet<>();
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[] { origin, "0", "0" });

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String[] pop = queue.poll();
                String src = pop[0];
                String color = pop[1];
                String level = pop[2];
                if (src == destination)
                    return Integer.parseInt(level);

                visited.add(new String[] { src, color });
                for (List<String> neighbor : adj.get(src)) {
                    String dest = neighbor.get(0);
                    String clr = neighbor.get(1);
                    String pair[] = { dest, clr };
                    if (clr != color && !visited.contains(pair)) {
                        queue.offer(new String[] { dest, color, level + 1 });
                    }
                }
            }
        }
        return -1;
    }
}
// Time Taken - 30 mins