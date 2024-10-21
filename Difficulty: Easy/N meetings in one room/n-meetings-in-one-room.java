//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.

   
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] meeting = new int[n][2];

        // Populate the meeting array with start and end times
        for (int i = 0; i < n; i++) {
            meeting[i][0] = start[i]; // Start time
            meeting[i][1] = end[i];   // End time (fixed here)
        }

        // Sort the meetings based on end times
        Arrays.sort(meeting, (a, b) -> a[1] - b[1]);

        int count = 1; // Count of meetings
        int lastMeetingEnd = meeting[0][1]; // End time of the last selected meeting

        // Iterate through the sorted meetings
        for (int i = 1; i < n; i++) {
            // If the start time of the current meeting is greater than
            // the end time of the last selected meeting
            if (meeting[i][0] > lastMeetingEnd) {
                count++; // Select this meeting
                lastMeetingEnd = meeting[i][1]; // Update the last end time
            }
        }

        return count; // Return the maximum number of meetings
    }

}
