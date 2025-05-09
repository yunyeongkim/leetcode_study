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