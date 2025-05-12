class Solution {
     public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int answer = 0;
        for (var price:prices){
            if (minPrice > price){
                minPrice = price;
            }else{
                answer = Math.max(answer,price-minPrice);
            }
        }
        return answer;
    }
}