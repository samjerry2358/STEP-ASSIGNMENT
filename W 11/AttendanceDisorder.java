import java.util.Arrays;

public class AttendanceDisorder {

    /**
     * Counts the total number of disorder pairs (inversions) in O(n log n) time.
     */
    public static long countInversions(int[] roll) {
        if (roll == null || roll.length <= 1) {
            return 0;
        }
        int[] temp = new int[roll.length];
        return mergeSortAndCount(roll, temp, 0, roll.length - 1);
    }

    private static long mergeSortAndCount(int[] roll, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in the left half
            count += mergeSortAndCount(roll, temp, left, mid);
            // Count inversions in the right half
            count += mergeSortAndCount(roll, temp, mid + 1, right);
            // Count cross-inversions during the merge step
            count += mergeAndCount(roll, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] roll, int[] temp, int left, int mid, int right) {
        int i = left;     // Starting index for left subarray
        int j = mid + 1;  // Starting index for right subarray
        int k = left;     // Starting index to be sorted
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (roll[i] <= roll[j]) {
                temp[k++] = roll[i++];
            } else {
                // If roll[i] > roll[j], then all remaining elements in the left subarray 
                // (from i to mid) are greater than roll[j], forming disorder pairs.
                temp[k++] = roll[j++];
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = roll[i++];
        }

        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = roll[j++];
        }

        // Copy back the sorted subarray into the original array
        for (i = left; i <= right; i++) {
            roll[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        // --- Sample 1 ---
        int[] roll1 = {2, 4, 1, 3, 5};
        System.out.println("Rolls: " + Arrays.toString(roll1));
        System.out.println("Disorder Score (Inversions): " + countInversions(roll1)); // Expected: 3

        // --- Sample 2 ---
        int[] roll2 = {5, 4, 3, 2, 1};
        System.out.println("\nRolls: " + Arrays.toString(roll2));
        System.out.println("Disorder Score (Inversions): " + countInversions(roll2)); // Expected: 10
    }
}