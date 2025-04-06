> [!question]+
> There is a biker going on a road trip. 
> The road trip consists of `n + 1` points at different altitudes. 
> The biker starts his trip on point `0` with altitude equal `0`.
> You are given an integer array `gain` of length `n` where `gain[i]` is the **net gain in altitude** between points `i`​​​​​​ and `i + 1` for all (`0 <= i < n)`. 
> Return _the **highest altitude** of a point._
>
>> [!example]+

###  Definition
- `(0 <= i < n)` 
- Maybe the greatest value? No!
- `[1,2,-1]`  -> +1 +2 = 3
- Given a product whose price changes day by day, find the **highest price** it has reached so far.
  
- **`net gain in altitude`** →  
    `net gain` means **pure (final) increase**, after considering any losses or decreases.  
    In this problem, it refers to the **pure change in height** between two points.
    
- In other words:
    > “How much the altitude increased (or decreased) from one point to the next.”
  
###  Explanation with Examples
Finance
- **`The investor reported a net gain of $10,000 after taxes and fees.`**  
    → After subtracting all costs, investor earned $10,000.  
    **"Net" means after everything is considered.**

Sports
- **`The hiker had a net gain of 300 meters by the end of the trail.`**  
    → Even though the trail had ups and downs, the hiker ended up 300m higher than where they started.  
    This is **not total climbing distance**, but the **final change in altitude.**

Data Analytics  
- **`There was a net gain of 2,000 users this month despite some account closures.`**

Physics
- **`The system showed a net gain in energy efficiency after redesigning the cooling unit.`**

Business
- **`Our marketing campaign led to a net gain of 15% in brand engagement.`**


### First code
```python
class Solution(object):
    def largestAltitude(self, gain):
        max = 0
        num = 0
        for i in range(len(gain)):
            num += gain[i]
            if max < num:
                max = num
        return max

# time O(n) / space O(1)
```