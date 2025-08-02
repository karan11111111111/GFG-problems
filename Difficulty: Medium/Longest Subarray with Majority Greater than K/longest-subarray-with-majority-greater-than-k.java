import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        // 1) Build prefix sums of +1/-1
        int[] pref = new int[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + (arr[i] > k ? 1 : -1);
        }

        // 2) Build a monotonic-decreasing stack of candidate start indices
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || pref[i] < pref[stack.peek()]) {
                stack.push(i);
            }
        }

        // 3) Scan j from n down to 0, popping valid starts
        int ans = 0;
        for (int j = n; j >= 0; j--) {
            while (!stack.isEmpty() && pref[j] > pref[stack.peek()]) {
                ans = Math.max(ans, j - stack.pop());
            }
        }

        return ans;
    }
}
