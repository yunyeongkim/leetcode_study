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