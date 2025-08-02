class Solution {
    // change return type from long to int
    public int countBalanced(String[] arr) {
        int totalBalanced = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int prefix = 0;
        freq.put(0, 1);

        for (String s : arr) {
            int net = 0;
            for (char ch : s.toLowerCase().toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    net += ("aeiou".indexOf(ch) >= 0) ? 1 : -1;
                }
            }
            prefix += net;
            int seen = freq.getOrDefault(prefix, 0);
            totalBalanced += seen;
            freq.put(prefix, seen + 1);
        }

        return totalBalanced;
    }
}
