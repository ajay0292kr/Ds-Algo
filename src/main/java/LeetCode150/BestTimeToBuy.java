package LeetCode150;

public class BestTimeToBuy {
    /*
     You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuy bestTimeToBuy = new BestTimeToBuy();
        System.out.println(bestTimeToBuy.maxProfit(prices));
    }
}
