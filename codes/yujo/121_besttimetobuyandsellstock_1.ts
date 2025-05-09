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