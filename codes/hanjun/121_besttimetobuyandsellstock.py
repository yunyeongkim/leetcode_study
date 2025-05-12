def maxProfit(self, prices: List[int]) -> int:
    profit = [0]
    min_price = prices[0]
    
    for current_price in prices[1:]:
        if min_price > current_price:
            min_price = current_price
        else: profit.append(current_price - min_price)
        
    return max(profit)