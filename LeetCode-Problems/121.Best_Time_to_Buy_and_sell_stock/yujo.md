# 121. Best Time to Buy and Sell Stock

## 1. Definition

- Given an array 'prices' containing price information.
- Each element in the array represents the stock price.
- You can only buy and sell stock once.
- Write a program to find the maximum profit.

## 2. First Code (5 min)

```ts
function maxProfit(prices: number[]): number {
  let buyPrice = prices[0];
  let profit = 0;

  for (let i = 1; i < prices.length; i++) {
    const todayProfit = prices[i] - buyPrice;

    profit = Math.max(todayProfit, profit);
    buyPrice = Math.min(buyPrice, prices[i]);
  }

  return profit;
}
```

## 3. First Code Explain

- Iterate through the array to buy at the lowest price.
- Calculate the difference between current price and minimum purchase price each time.
- Update the maximum profit.

## 4. Optimized Code

```ts
// Cannot make profit if array length is less than 2
if (prices.length < 2) return 0;

let minPrice = prices[0];
let maxProfit = 0;

for (let i = 1; i < prices.length; i++) {
  const currentPrice = prices[i];

  if (currentPrice > minPrice) {
    const currentProfit = currentPrice - minPrice;
    if (currentProfit > maxProfit) {
      maxProfit = currentProfit;
    }
  } else if (currentPrice < minPrice) {
    minPrice = currentPrice;
  }
}

return maxProfit;
```

## 5. Optimized Code Explain

- Couldn't find a significantly better solution.
- However, added a guard clause and used conditionals when initializing maxProfit and minPrice to update values only when necessary.
