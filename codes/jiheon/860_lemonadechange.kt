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