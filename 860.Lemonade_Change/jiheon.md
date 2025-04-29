[problem](https://leetcode.com/problems/lemonade-change/)

## IDEA
- If possible, giving change with a $10 bill is always better than two $5 bills

## code/solution
- Initialize two variables to keep track of the number of $5 and $10 bills (`count5`, `count10`)
- If the customer pays with a $5 bill, there's nothing to do - just increase `count5` by 1.
- If the customer pays with a $10 bill, there is only one way to give change - decrease `count5` by 1 and increase `count10` by 1
- If the customer pays with a $20 bill:
	- If we can give change using one $10 bill and  one $5 bill, - decrease the count of each by 1.
	- Otherwise, decrease `count5` by 3.
- In each iteration, if `count5` becomes less than 0, return false.


```java
class Solution {
      public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int bill:bills){
            switch (bill){
                case 10 -> {
                    if (count5 == 0){
                        return false;
                    }
                    count5--;
                    count10++;
                }

                case 20 -> {
                    if (count10 > 0 && count5 > 0){
                        count10--;
                        count5 --;
                    }else if (count5 >= 3){
                        count5-=3;
                    }else{
                        return false;
                    }
                }

                default -> count5 ++;
            }
        }

        return true;
    }

}
```


```kotlin
class Solution {
   fun lemonadeChange(bills: IntArray): Boolean {
        var count5 = 0
        var count10 = 0

        for (bill in bills){
            when (bill){
                5-> count5++
                10->{
                    if (count5 == 0) return false
                    count5--
                    count10++
                }
                20->{
                    if (count10 > 0 && count5 > 0) {
                        count10--
                        count5--
                    }else if (count5 >=3) count5-=3
                    else return false
                }
            }
        }

        return true
    }
}
````