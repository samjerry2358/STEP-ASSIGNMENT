import java.util.Arrays;

public class PlacementCutoff {

    /**
     * Finds the k-th highest mark in O(n) average time using Quickselect.
     */
    public static int kthHighest(int[] marks, int k) {
        if (marks == null || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid input or k out of bounds.");
        }

        // The k-th highest element corresponds to index (n - k) in ascending order.
        int targetIndex = marks.length - k;
        int low = 0;
        int high = marks.length - 1;

        while (low <= high) {
            int pivotIndex = partition(marks, low, high);

            if (pivotIndex == targetIndex) {
                return marks[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }

        return -1; // Should never be reached if inputs are valid
    }

    /**
     * Standard QuickSort partition using the last element as the pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // Place the pivot in its correct sorted position
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void main(String[] args) {
        // --- Sample 1 ---
        int[] marks1 = {72, 95, 60, 88, 79};
        int k1 = 2;
        System.out.println("Marks: " + Arrays.toString(marks1) + ", k = " + k1);
        System.out.println("Expected: 88 | Output: " + kthHighest(marks1, k1));

        // --- Sample 2 ---
        int[] marks2 = {50, 90, 90, 70};
        int k2 = 2;
        System.out.println("\nMarks: " + Arrays.toString(marks2) + ", k = " + k2);
        System.out.println("Expected: 90 | Output: " + kthHighest(marks2, k2));
    }
}