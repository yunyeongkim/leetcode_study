# 121. Best Time to Buy and Sell Stock

[problem][https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/]

### Intuition

To solve this problem, we need to find `min_price` and have to iterate over the indices of the array and calculate the `profit`.



### Method: ;Time: O(N), Space: O(N)

```python
def maxProfit(self, prices: List[int]) -> int:
    profit = [0]
    min_price = prices[0]
    
    for current_price in prices[1:]:
        if min_price > current_price:
            min_price = current_price
        else: profit.append(current_price - min_price)
        
    return max(profit)
```

If we want to reduce memory space usage, we can update the maximum value when calculating the profit without using an array.

