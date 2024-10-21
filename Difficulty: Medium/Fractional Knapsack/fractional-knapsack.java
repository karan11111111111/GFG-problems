//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
     class Item {
        int value;
        int weight;
        double ratio;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    // Function to get the maximum total value in the knapsack.
   public double fractionalKnapsack(List<Integer> values, List<Integer> weights, int W) {
        // Number of items
        int n = values.size();
        
        // Create an array of items
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(values.get(i), weights.get(i)));
        }

        // Sort items by their value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0; // Maximum value that can be obtained
        int remainingCapacity = W;

        // Loop through sorted items
        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                // If the item can fit fully, take it
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // If the item can't fit fully, take the fraction that fits
                totalValue += item.ratio * remainingCapacity;
                break; // Knapsack is full
            }
        }

        return totalValue; // Return the total maximum value
    }
}