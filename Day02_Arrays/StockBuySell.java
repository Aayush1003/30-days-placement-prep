/**
 * Stock Buy and Sell — Maximum Profit
 * 
 * Problem: Given prices of a stock on each day, find the maximum profit
 *          by buying on one day and selling on a future day.
 * 
 * Approach: Track the minimum price so far, compute profit at each step.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class StockBuySell {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Prices: [7, 1, 5, 3, 6, 4]");
        System.out.println("Max Profit: " + maxProfit(prices)); // Output: 5 (buy@1, sell@6)

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("\nPrices: [7, 6, 4, 3, 1]");
        System.out.println("Max Profit: " + maxProfit(prices2)); // Output: 0 (no profit)
    }
}
