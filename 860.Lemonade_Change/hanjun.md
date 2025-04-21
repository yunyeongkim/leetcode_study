# 860. Lemonade Change

[problem][https://leetcode.com/problems/lemonade-change/description/]

### Intuition

We need to check the number of dollars. 



### Method: Time: O(N)

```python
def lemonadeChange(self, bills: List[int]) -> bool:
    if bills[0] != 5: return False
    fives, tens = 0 , 0
    for bill in bills:
        if bill == 5:
            fives += 1
        else bill == 10:
            if fives == 0:
                return False
            fives -= 1
            tens += 1
        else:
            if tens > 0 and fives > 0:
                tens -= 1
                five -= 1
            elif fives >= 3:
                fives -= 3
            else: return False
        return True
```

