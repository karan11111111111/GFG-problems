// class Solution {
//     public long subarrayXor(int arr[], int k) {
//         // code here
//         int count=0;
//         for(int i=0; i<arr.length; i++){
//             int xor =0;
//             for(int j=i; j<arr.length; j++){
//                 xor ^= arr[j];
//                 if(xor == k){
//                     count++;
//                 }
//             }
//         }
        
//         return count;
//     }
// }
class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        long count = 0;

        for (int num : arr) {
            prefixXor ^= num;

            if (prefixXor == k) {
                count++;
            }

            int required = prefixXor ^ k;
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
