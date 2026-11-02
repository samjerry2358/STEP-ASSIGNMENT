import java.util.Arrays;

public class NoticeBoardShuffle {

    /**
     * Sorts the array in-place using optimized Bubble Sort.
     * Returns an array containing {passes, swaps}.
     */
    public static int[] bubbleStats(int[] scores) {
        if (scores == null || scores.length <= 1) {
            return new int[] { 0, 0 };
        }

        int passes = 0;
        int swaps = 0;
        int n = scores.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;

            // Perform a single sweep of adjacent neighbor swaps
            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    // Swap scores[j] and scores[j+1]
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            // Stop early if no swaps were made during this full sweep
            if (!swapped) {
                break;
            }
        }

        return new int[] { passes, swaps };
    }

    public static void main(String[] args) {
        // --- Sample 1 ---
        int[] scores1 = { 5, 1, 4, 2, 8 };
        int[] stats1 = bubbleStats(scores1);
        
        System.out.println("Sample 1 Results:");
        System.out.println("Sorted Array: " + Arrays.toString(scores1));
        System.out.println("Passes = " + stats1[0] + ", Swaps = " + stats1[1]);

        // --- Sample 2 ---
        int[] scores2 = { 1, 2, 3, 4 };
        int[] stats2 = bubbleStats(scores2);
        
        System.out.println("\nSample 2 Results:");
        System.out.println("Sorted Array: " + Arrays.toString(scores2));
        System.out.println("Passes = " + stats2[0] + ", Swaps = " + stats2[1]);
    }
}