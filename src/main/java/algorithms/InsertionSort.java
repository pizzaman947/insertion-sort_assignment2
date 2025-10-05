package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private final PerformanceTracker tracker = new PerformanceTracker();

    public void sort(int[] arr) {
        tracker.reset();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            tracker.incrementArrayAccesses(); 
            int key = arr[i];
            int j = i - 1;

            int insertPos = binarySearch(arr, key, 0, j);

            j = i - 1;
            while (j >= insertPos) {
                tracker.incrementArrayAccesses(2); 
                arr[j + 1] = arr[j];
                j--;
            }
            
            tracker.incrementArrayAccesses(); 
            arr[j + 1] = key;
            tracker.incrementSwaps();
        }
    }

    private int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            tracker.incrementComparisons();
            int mid = low + (high - low) / 2;
            
            tracker.incrementArrayAccesses(); 
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }
}