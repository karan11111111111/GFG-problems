class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        // Count frequencies
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        
        // Build result: each pair = {value, frequency}
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            li.add(pair);
        }
        
        return li;
    }
}
