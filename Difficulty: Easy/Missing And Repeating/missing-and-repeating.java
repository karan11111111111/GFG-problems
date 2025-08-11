// import java.util.*;

// class Solution {
//     ArrayList<Integer> findTwoElement(int arr[]) {
//         int n = arr.length;
//         ArrayList<Integer> result = new ArrayList<>();

//         int repeating = -1, missing = -1;

        
//         for (int i = 1; i <= n; i++) {
//             int count = 0;
            
//             for (int j = 0; j < n; j++) {
//                 if (arr[j] == i) {
//                     count++;
//                 }
//             }

//             if (count == 2) {
//                 repeating = i;
//             } else if (count == 0) {
//                 missing = i;
//             }
//         }

//         result.add(repeating);
//         result.add(missing);

//         return result;
//     }
// }


import java.util.*;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        long Sn = (long) n * (n + 1) / 2; 
        long Pn = (long) n * (n + 1) * (2L * n + 1) / 6; 

        long S = 0, P = 0;
        for (int num : arr) {
            S += num;
            P += (long) num * num;
        }

        long diff = S - Sn; 
        long diffSq = P - Pn; 
        long sum = diffSq / diff; 
        long repeating = (diff + sum) / 2;
        long missing = repeating - diff;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) repeating);
        ans.add((int) missing);

        return ans;
    }
}
