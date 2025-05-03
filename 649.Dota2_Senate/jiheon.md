[problem](https://leetcode.com/problems/dota2-senate/description/)

The general way to solve this problem is by using  a data structure like a deque, but we can solve it without one.

## Solution

The best strategy in this game is to *always ban the other party's senators*.

### 1.With deque
> -  The variables `rcnt`,`dcnt` represent the number of surviving senators from each party.
>-  `rscore` represents the current balance of ban counts. If `rscore > 0`, the `Radiant` party has the advantage.
> While iterating through the array, we can use 'R' as an example:
> 	- `rscore>=0` indicates the `Radiant` party gains one more ban card, and their current senator will survive. So we  add the current senator to the back of the deque.
>	- `rscore<0` indicates current senator has been banned. They can't do anything but  consume one of Dire's ban cards. 
> 	- In both cases, increment `rscore` to update the party's ban count.
>- This game continues until one of the parties is completely eliminated.
```java
class Solution {
    public String predictPartyVictory(String senate) {
        int rcnt = 0, dcnt = 0, rscore = 0;
        var dq = new ArrayDeque<Character>();
        for (var c : senate.toCharArray()) {
            if (c == 'R')rcnt++;
            else dcnt++;
            dq.add(c);
        }

        while (rcnt > 0 && dcnt > 0) {
            var tmp = dq.pollFirst();
            if (tmp == 'R') {
                if (rscore < 0)rcnt--;
                else dq.addLast(tmp);
                rscore++;
            } else {
                if (rscore > 0)dcnt--;
                else dq.addLast(tmp);
                rscore--;
            }
        }
        return rcnt == 0 ? "Dire" : "Radiant";
    }
}
```



## 2. without deque

Instead of using a deque, we can update the original array directly. The logic will be similar.

> - `rscore>=0` indicates  that the current senator  will survive the next round, so we  update the original array by placing `R` at the front.
> - If the absolute value of `rScore` is greater than or equal to idx, it means one party has been completely eliminated, so we can determine the winning party.
> 
>*The variable `length` represents the  number of valid elements in the array. It will decrease with  each new round .*
	


```kotlin
class Solution {
    fun predictPartyVictory(senate: String): String {

        val charArray = senate.toCharArray()
        var rScore = 0;

        fun helper(length: Int = senate.length): String {
            var idx = 0;

            for (i in 0 until length) {
                val c = charArray[i];

                if (c == 'R') {
                    if (rScore >= 0) charArray[idx++] = 'R'
                    rScore++
                } else {
                    if (rScore <= 0) charArray[idx++] = 'D'
                    rScore--;
                }
            }

            if (abs(rScore) >= idx) return if (rScore > 0) "Radiant" else "Dire"
            
            return helper(idx)
        }
        return helper()
    }
}
```