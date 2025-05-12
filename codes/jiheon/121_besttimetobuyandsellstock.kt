class Solution {
    fun maxProfit(prices: IntArray): Int {
        var answer = 0;
        var minPrice = Int.MAX_VALUE;
        for (price in prices){
               if (price< minPrice) minPrice = price
               else answer = max(answer,price-minPrice);
        }
        return answer
    }
}