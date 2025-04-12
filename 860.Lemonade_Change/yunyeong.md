
> [!question]+ Each lemonade costs **$5**. Customers queue and pay with **$5, $10, or $20**. You must return exact change. You have no initial cash.
> 
> Given `bills[]`, where `bills[i]` is the bill the i-th customer gives, return `true` if you can return correct change to all customers, else return `false`.

### Definition

1. Each customer buys **one lemonade** ($5).
2. Payment can be $5, $10, or $20 only.    
3. You must return **exact change** for each customer.
4. You start with **zero money**.
### Example

> [!example]+ **Input:** bills = [5,5,5,10,20]  
> **Output:** true  
> **Explanation:**
> 
> - 3 customers pay with $5 → no change needed → you have three $5 bills
>     
> - 4th pays with $10 → give $5 change → now two $5, one $10
>     
> - 5th pays with $20 → give $10 + $5 change → now one $5, zero $10
>     

> [!example]+ **Input:** bills = [5,5,10,10,20]  
> **Output:** false  
> **Explanation:**
> 
> - No $5 change for last customer
>     

### First Attempt

```python
class Solution:
    def lemonadeChange(self, bills):
        five, ten = 0, 0
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if five == 0:
                    return False
                five -= 1
                ten += 1
            else:  # bill == 20
                if ten > 0 and five > 0:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
        return True
```
### Greedy Explanation
- Always give change using **larger bills first** (prefer $10 + $5 over $5+$5+$5).
- This preserves more $5 bills for future $10 change needs.

#### Greedy Flow
1. If $5: accept
2. If $10: give one $5
3. If $20:
    - If $10 and $5 exist → give one of each
    - Else if at least 3 x $5 → give them
    - Else → return False
### Complexity

|Measure|Value|
|---|---|
|Time|O(n)|
|Space|O(1)|

### Pattern: Greedy

- Make the **locally optimal choice** (largest bills out first)
- Leads to **global correctness** (survive all change requests)

---

### Visualization (Optional)

![[LemonadeChangeDiagram.excalidraw]]