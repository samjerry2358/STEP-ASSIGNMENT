// Class representing a Contest Entry with a student name and marks
class Entry {
    String name;
    int marks;

    public Entry(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}

public class ContestLeaderboard {

    /**
     * Sorts the entries from highest marks to lowest in O(n + 101) time 
     * using Counting Sort with key = 100 - marks.
     */
    public static Entry[] leaderboard(Entry[] entries) {
        if (entries == null) {
            return null;
        }

        int n = entries.length;
        Entry[] output = new Entry[n];
        
        // Marks range from 0 to 100, so there are 101 possible values (0 to 100).
        int range = 101;
        int[] count = new int[range];
        int[] keys = new int[n];

        // Step 1: Compute keys (key = 100 - marks) so higher marks map to smaller keys,
        // and count frequencies of each key.
        for (int i = 0; i < n; i++) {
            keys[i] = 100 - entries[i].marks;
            count[keys[i]]++;
        }

        // Step 2: Build cumulative counts so each value stores the ending position.
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements into the output array by walking from RIGHT to LEFT.
        // Walking right-to-left ensures stability (ties keep original submission order).
        for (int i = n - 1; i >= 0; i--) {
            int key = keys[i];
            int position = count[key] - 1;
            output[position] = entries[i];
            count[key]--;
        }

        return output;
    }

    // Helper method to print entries in the required format
    public static void printLeaderboard(Entry[] entries) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entries.length; i++) {
            sb.append(entries[i].name).append(" ").append(entries[i].marks);
            if (i < entries.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // Sample Input: Asha 90, Ravi 75, Neha 90, Kiran 100, Meera 75
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        System.out.print("Before Leaderboard Sorting: ");
        printLeaderboard(entries);

        // Get sorted leaderboard
        Entry[] sortedEntries = leaderboard(entries);

        System.out.print("Expected Output Format:   ");
        System.out.println("Kiran 100, Asha 90, Neha 90, Ravi 75, Meera 75");
        
        System.out.print("Actual Output:            ");
        printLeaderboard(sortedEntries);
    }
}