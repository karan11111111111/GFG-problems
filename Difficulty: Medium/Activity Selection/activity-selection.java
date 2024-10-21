//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            List<Integer> start = new ArrayList<>();
            for (String s : startInput) {
                start.add(Integer.parseInt(s));
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            List<Integer> end = new ArrayList<>();
            for (String s : endInput) {
                end.add(Integer.parseInt(s));
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, end));
        }
    }
}

// } Driver Code Ends








class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        // Number of activities
        int n = start.size();
        if (n == 0) return 0;

        // Array to store index of activities after sorting based on end time
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort activities based on end time using comparator
        Arrays.sort(indices, (i, j) -> end.get(i) - end.get(j));

        // Initialize count of selected activities
        int maxAct = 1;
        int lastEnd = end.get(indices[0]);

        // Iterate through activities and select compatible ones
        for (int i = 1; i < n; i++) {
            if (start.get(indices[i]) > lastEnd) {
                maxAct++;
                lastEnd = end.get(indices[i]); // Update lastEnd to the end time of the selected activity
            }
        }

        return maxAct;
    }
}
