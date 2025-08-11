class Solution {
    public void mergeArrays(int a[], int b[]) {
        int n = a.length, m = b.length;
        int[] merged = new int[n + m];

        
        int k = 0;
        for (int x : a) merged[k++] = x;
        for (int x : b) merged[k++] = x;

    
        java.util.Arrays.sort(merged);

        // Copy back to a[] and b[]
        for (int i = 0; i < n; i++) a[i] = merged[i];
        for (int i = 0; i < m; i++) b[i] = merged[n + i];
    }
}
