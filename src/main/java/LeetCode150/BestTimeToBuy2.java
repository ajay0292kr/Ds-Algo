package LeetCode150;

public class BestTimeToBuy2 {
    /*
      On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However,
      you can sell and buy the stock multiple times on the same day, ensuring you never hold than one share of the stock.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Loop through the prices array
        for (int i = 1; i < prices.length; i++) {
            // If the price at day i is higher than the price at day (i - 1), we add the difference to the maxProfit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuy2 bestTimeToBuy2 = new BestTimeToBuy2();
        System.out.println(bestTimeToBuy2.maxProfit(prices));
    }
}
