// class Solution {
//     public int countRevPairs(int[] arr) {
//         int n = arr.length;
//         int count = 0;
        
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[i] > 2L * arr[j]) { 
//                     count++;
//                 }
//             }
//         }
        
//         return count;
//     }
// }

class Solution {
    public int countRevPairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    private int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;
        
        int mid = (left + right) / 2;
        int count = mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right);
        
    
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        
     
        merge(arr, left, mid, right);
        return count;
    }
    
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }
}
