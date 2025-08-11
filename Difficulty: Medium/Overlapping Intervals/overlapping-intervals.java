// import java.util.*;

// class Solution {
//     public ArrayList<int[]> mergeOverlap(int[][] arr) {
//         ArrayList<int[]> list = new ArrayList<>();

        
//         for (int[] interval : arr) {
//             list.add(interval);
//         }

//         boolean merged = true;
//         while (merged) {
//             merged = false;
//             for (int i = 0; i < list.size(); i++) {
//                 for (int j = i + 1; j < list.size(); j++) {
//                     int[] a = list.get(i);
//                     int[] b = list.get(j);

                    
//                     if (a[0] <= b[1] && b[0] <= a[1]) {
                       
//                         int newStart = Math.min(a[0], b[0]);
//                         int newEnd = Math.max(a[1], b[1]);
//                         list.set(i, new int[]{newStart, newEnd});
//                         list.remove(j);
//                         merged = true;
//                         break; 
//                     }
//                 }
//                 if (merged) break; 
//             }
//         }

//         return list;
//     }
// }
import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        ArrayList<int[]> result = new ArrayList<>();
        
        if (arr.length == 0) return result;

        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

       
        int[] current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= current[1]) {
              
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                
                result.add(current);
                current = arr[i];
            }
        }

    
        result.add(current);

        return result;
    }
}
