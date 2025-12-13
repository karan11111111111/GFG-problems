class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        long maxSum = -1;
        long currSum = 0;
        int start = 0;
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 0) {
                currSum += arr[i];

                if (currSum > maxSum || 
                   (currSum == maxSum && (i - start) > (bestEnd - bestStart))) {

                    maxSum = currSum;
                    bestStart = start;
                    bestEnd = i;
                }

            } else {
                currSum = 0;
                start = i + 1;
            }
        }

        if (maxSum == -1) {
            result.add(-1);
            return result;
        }

        for (int i = bestStart; i <= bestEnd; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
