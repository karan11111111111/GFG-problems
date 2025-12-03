class Solution {
    public int findUnique(int[] arr) {

        Map<Integer, Integer> mp = new HashMap<>();

        // Step 1: build frequency map
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: find element with frequency 1
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1; // if no unique element
    }
}
