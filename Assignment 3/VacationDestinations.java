
import java.util.*;

// Technique: Graph BFS
// Time Complexity: O(V+E)
// Space Complexity: O(V+E)
public class VacationDestinations {
    public static class City {
        String name;
        double travelTime;

        City(String name, double travelTime) {
            this.name = name;
            this.travelTime = travelTime;
        }
    }

    public static void main(String[] args) {
        String[][] pairs = { { "Boston", "New York", "4" },
                { "New York", "Philadelphia", "2" },
                { "Boston", "Newport", "1.5" },
                { "Washington, D.C.", "Harper's Ferry", "1" },
                { "Boston", "Portland", "2.5" },
                { "Philadelphia", "Washington, D.C.", "2.5" } };
        String origin = "New York";
        double travelTime = 5;
        System.out.println(numDestinations(origin, travelTime, pairs));
    }

    public static int numDestinations(String origin, double maxTravelTime, String[][] destinations) {
        Map<String, List<City>> adj = new HashMap<>();
        for (String[] dest : destinations) {
            String city1 = dest[0];
            String city2 = dest[1];
            double travelTime = Double.parseDouble(dest[2]);
            adj.putIfAbsent(city1, new ArrayList<>());
            adj.putIfAbsent(city2, new ArrayList<>());
            adj.get(city1).add(new City(city2, travelTime));
            adj.get(city2).add(new City(city1, travelTime));
        }

        int res = 0;
        Set<String> visited = new HashSet<>();
        Queue<City> queue = new LinkedList<>();
        queue.offer(new City(origin, 0));
        while (!queue.isEmpty()) {
            City curCity = queue.poll();
            String cityName = curCity.name;
            double travelTime = curCity.travelTime;
            if (travelTime <= maxTravelTime && !visited.contains(cityName)) {
                res++;
                visited.add(cityName);

                for (City neighbor : adj.get(cityName)) {
                    queue.offer(new City(neighbor.name, travelTime + neighbor.travelTime + 1));
                }
            }
        }
        return res;
    }
}
// Time Taken: 23 mins
