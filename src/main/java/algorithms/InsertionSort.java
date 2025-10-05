package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private static PerformanceTracker tracker = new PerformanceTracker();

    public static void sort(int[] arr) {
        tracker.reset();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            tracker.incrementComparisons();

            int insertPos = binarySearch(arr, key, 0, j);

            while (j >= insertPos) {
                tracker.incrementArrayAccesses();
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            tracker.incrementSwaps();
        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            tracker.incrementComparisons();
            int mid = low + (high - low) / 2;
            if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static PerformanceTracker getTracker() {
        return tracker;
    }
}
