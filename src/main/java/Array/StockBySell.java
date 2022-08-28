package Array;

public class StockBySell {
    public static int maxProfit(int[] price, int n) {
        int maxProfit = 0;
        for(int i = 1; i < n; i++) {
            if(price[i] > price[i-1]) {
                maxProfit += price[i] - price[i-1];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] price = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        // function call
        System.out.println(maxProfit(price, n));
    }
}
