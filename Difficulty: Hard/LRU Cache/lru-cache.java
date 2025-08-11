// import java.util.*;

// class LRUCache {
//     private int capacity;
//     private List<int[]> cache; 

//     LRUCache(int cap) {
//         capacity = cap;
//         cache = new ArrayList<>();
//     }

//     public int get(int key) {
//         for (int i = 0; i < cache.size(); i++) {
//             if (cache.get(i)[0] == key) {
//                 int[] pair = cache.remove(i); 
//                 cache.add(pair); 
//                 return pair[1];
//             }
//         }
//         return -1; 
//     }

//     public void put(int key, int value) {
       
//         for (int i = 0; i < cache.size(); i++) {
//             if (cache.get(i)[0] == key) {
//                 cache.remove(i);
//                 break;
//             }
//         }
        
//         if (cache.size() >= capacity) {
//             cache.remove(0);
//         }
       
//         cache.add(new int[]{key, value});
//     }
// }

