class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int left = 0;
        int maxProfit = 0;

        for(int right = 1; right < prices.length; right++) {
            if(prices[left] >= prices[right]) {
                // cheap buying day
                left = right;
            } else {
                // Selling brings win
                if(prices[right] - prices[left] > maxProfit) {
                    maxProfit = prices[right] - prices[left];
                }
            }
        }

        return maxProfit;
    }
}
