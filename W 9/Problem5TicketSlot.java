public class Problem5TicketSlot {
    public static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        System.out.println("Sample 1 - Expected: 1 | Actual: " + findSlot(prices, 150));
        System.out.println("Sample 2 - Expected: 3 | Actual: " + findSlot(prices, 210));
        System.out.println("Sample 3 - Expected: 4 | Actual: " + findSlot(prices, 300));
    }
}