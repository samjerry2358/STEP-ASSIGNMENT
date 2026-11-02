import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2MergeTokens {
    /**
     * Merges two sorted lists into a single sorted list preserving duplicates[cite: 2].
     */
    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < counterA.size() && j < counterB.size()) {
            if (counterA.get(i) <= counterB.get(j)) {
                merged.add(counterA.get(i));
                i++;
            } else {
                merged.add(counterB.get(j));
                j++;
            }
        }
        
        while (i < counterA.size()) {
            merged.add(counterA.get(i++));
        }
        while (j < counterB.size()) {
            merged.add(counterB.get(j++));
        }
        
        return merged;
    }

    public static void main(String[] args) {
        List<Integer> counterA = Arrays.asList(3, 8, 15, 20);
        List<Integer> counterB = Arrays.asList(5, 8, 12);
        List<Integer> result = mergeTokens(counterA, counterB);
        System.out.println("Expected Output: [3, 5, 8, 8, 12, 15, 20]");
        System.out.println("Actual Output:   " + result);
    }
}
