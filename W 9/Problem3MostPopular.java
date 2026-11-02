import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3MostPopular {
    public static class PopularResult {
        public String item;
        public int count;
        
        public PopularResult(String item, int count) {
            this.item = item;
            this.count = count;
        }
        
        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static PopularResult mostPopular(List<String> orders) {
        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        
        int maxCount = -1;
        String bestItem = null;
        
        for (String item : orders) {
            int c = counts.get(item);
            if (c > maxCount) {
                maxCount = c;
                bestItem = item;
            }
        }
        
        return new PopularResult(bestItem, maxCount);
    }

    public static void main(String[] args) {
        List<String> orders = Arrays.asList("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea");
        PopularResult result = mostPopular(orders);
        System.out.println("Expected Output: (\"dosa\", 3)");
        System.out.println("Actual Output:   " + result);
    }
}