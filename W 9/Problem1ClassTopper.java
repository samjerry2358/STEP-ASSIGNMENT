public class Problem1ClassTopper {
    /**
     * Finds the student with the highest total marks.
     * Returns an int array where [rowIndex, total]. Ties broken by smallest row index.
     */
    public static int[] findTopper(int[][] marks) {
        int bestRow = 0;
        int maxTotal = -1;
        
        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int mark : marks[i]) {
                currentTotal += mark;
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }
        return new int[] { bestRow, maxTotal };
    }

    public static void main(String[] args) {
        // Test case from the assignment PDF
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };
        
        int[] result = findTopper(marks);
        System.out.println("Expected Output: (1, 259)");
        System.out.println("Actual Output: (" + result[0] + ", " + result[1] + ")");
    }
}