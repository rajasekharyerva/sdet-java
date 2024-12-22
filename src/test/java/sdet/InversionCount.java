package sdet;

public class InversionCount {
    public static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // Left subarray index
        int j = mid + 1;  // Right subarray index
        int k = left;     // Temp array index
        int inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy sorted subarray back to original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversions;
    }

    public static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int inversions = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in the left half
            inversions += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right half
            inversions += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions
            inversions += mergeAndCount(arr, temp, left, mid, right);
        }
        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int[] temp = new int[arr.length];
        int inversions = mergeSortAndCount(arr, temp, 0, arr.length - 1);
        System.out.println("Number of Inversions: " + inversions);
    }
}

