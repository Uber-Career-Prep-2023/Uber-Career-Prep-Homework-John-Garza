
// Technique: Topological Sort with Khan's Algo
// Time Complexity: O(V+E) since outer loop executed V time and inner E times
// Space Complexity: O(V) to use the queue to store the vertices for graph
import java.util.*;

public class PrerequisiteCourses {
    public static void main(String[] args) {
        String[] courseList1 = { "Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems",
                "Databases" };
        String[][] prereqs1 = { { "Data Structures", "Intro to Programming" },
                { "Advanced Algorithms", "Data Structures" }, { "Operating Systems", "Advanced Algorithms" },
                { "Databases", "Advanced Algorithms" } };
        String[] res1 = prereqCourses(courseList1, prereqs1);
        for (String s : res1) {
            System.out.print(s + ", ");
        }

    }

    public static String[] prereqCourses(String[] courseList, String[][] prereqs) {
        Map<String, List<String>> adj = new HashMap<>();
        for (String s : courseList) {
            adj.put(s, new ArrayList<>());
        }
        for (String[] s : prereqs) {
            String course = s[0];
            String prereqCourse = s[1];
            // System.out.println(prereqCourse);
            // adj.putIfAbsent(prereqCourse, new ArrayList<>());
            adj.get(prereqCourse).add(course);
        }

        Map<String, Integer> visited = new HashMap<>();
        for (String str : courseList) {
            visited.put(str, 0);
        }

        List<String> res = new ArrayList<>();
        for (String str : courseList) {
            if (!topoSort(res, adj, visited, str)) {
                return new String[0];
            }
        }

        String[] result = new String[courseList.length];
        for (int i = 0; i < courseList.length; i++) {
            result[i] = res.get(courseList.length - i - 1);
        }

        return result;
    }

    public static boolean topoSort(List<String> res, Map<String, List<String>> adj, Map<String, Integer> visited,
            String str) {
        int visit = visited.get(str);
        if (visit == 2)
            return true;
        if (visit == 1)
            return false;
        visited.put(str, 1);
        for (String s : adj.get(str)) {
            if (!topoSort(res, adj, visited, s)) {
                return false;
            }
        }
        visited.put(str, 2);
        res.add(str);
        return true;
    }
}
// Time Taken: 45 mins
