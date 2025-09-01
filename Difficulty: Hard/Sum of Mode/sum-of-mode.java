// class Solution {
   
//         // code here
//           public int sumOfModes(int[] arr, int k) {
//         int n = arr.length;
//         int sum = 0;

//         Map<Integer, Integer> freq = new HashMap<>();
        
//         // Initialize first window
//         for (int i = 0; i < k; i++) {
//             freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
//         }
//         sum += getMode(freq);

//         // Slide the window
//         for (int i = k; i < n; i++) {
//             // Remove outgoing element
//             int out = arr[i - k];
//             freq.put(out, freq.get(out) - 1);
//             if (freq.get(out) == 0) {
//                 freq.remove(out);
//             }

//             // Add incoming element
//             int in = arr[i];
//             freq.put(in, freq.getOrDefault(in, 0) + 1);

//             // Find mode of current window
//             sum += getMode(freq);
//         }

//         return sum;
//     }

//     private int getMode(Map<Integer, Integer> freq) {
//         int mode = Integer.MAX_VALUE;
//         int maxFreq = 0;

//         for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
//             int num = entry.getKey();
//             int count = entry.getValue();

//             if (count > maxFreq || (count == maxFreq && num < mode)) {
//                 maxFreq = count;
//                 mode = num;
//             }
//         }
//         return mode;
//     }
// }
class Solution {
   
        public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> bucket = new TreeMap<>();

        // helper to add num
        Runnable addNum = null, removeNum = null;

        // method to insert element
        class Helper {
            void insert(int num) {
                int old = freq.getOrDefault(num, 0);
                int now = old + 1;
                freq.put(num, now);

                // remove from old bucket
                if (old > 0) {
                    TreeSet<Integer> set = bucket.get(old);
                    set.remove(num);
                    if (set.isEmpty()) bucket.remove(old);
                }

                // add to new bucket
                bucket.putIfAbsent(now, new TreeSet<>());
                bucket.get(now).add(num);
            }

            void erase(int num) {
                int old = freq.get(num);
                int now = old - 1;

                // remove from old bucket
                TreeSet<Integer> set = bucket.get(old);
                set.remove(num);
                if (set.isEmpty()) bucket.remove(old);

                if (now == 0) {
                    freq.remove(num);
                } else {
                    freq.put(num, now);
                    bucket.putIfAbsent(now, new TreeSet<>());
                    bucket.get(now).add(num);
                }
            }
        }

        Helper helper = new Helper();

        // First window
        for (int i = 0; i < k; i++) helper.insert(arr[i]);

        int sum = 0;
        sum += bucket.lastEntry().getValue().first(); // mode of first window

        for (int i = k; i < n; i++) {
            helper.erase(arr[i - k]);
            helper.insert(arr[i]);
            sum += bucket.lastEntry().getValue().first();
        }

        return sum;
    }

}