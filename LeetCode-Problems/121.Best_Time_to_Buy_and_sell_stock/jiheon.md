[problem](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

# Code/Solution
- Initialize a variable `minPrice` with `Integer.MAX_VALUE`.
- Initialize a variable `answer` with 0.
- Iterate through the array `prices`:
    - If the current price is lower than minPrice, update minPrice to the current price.
    - Otherwise,  calculate the profit we would get if we sold at the current price, and update `answer` with the maximum of the current profit  and existing `answer`.


```java
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
```

```kotlin
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
```