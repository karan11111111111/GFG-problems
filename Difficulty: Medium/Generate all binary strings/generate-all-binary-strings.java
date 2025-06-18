// User function Template for Java

import java.util.*;

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(n, 0, str, result);
        return result;
    }

    private static void helper(int n, int lastPlace, StringBuilder str, List<String> result) {
        // Base case
        if (n == 0) {
            result.add(str.toString());
            return;
        }

        // Append '0'
        str.append("0");
        helper(n - 1, 0, str, result);
        str.deleteCharAt(str.length() - 1); // backtrack

        // Append '1' only if lastPlace is 0
        if (lastPlace == 0) {
            str.append("1");
            helper(n - 1, 1, str, result);
            str.deleteCharAt(str.length() - 1); // backtrack
        }
    }
}
