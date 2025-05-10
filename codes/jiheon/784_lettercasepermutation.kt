class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val ans = ArrayList<String>(s.length * s.length)
        val sb = StringBuilder(s.length)

        fun dfs(idx: Int = 0) {
            if (idx == s.length) {
                ans.add(sb.toString())
                return
            }

            val c = s[idx]

            if (c.isDigit()) {
                sb.append(c)
                dfs(idx + 1)
                sb.setLength(sb.length - 1)
            } else {
                sb.append(c.uppercaseChar())
                dfs(idx + 1)
                sb.setLength(sb.length - 1)
                
                sb.append(c.lowercaseChar())
                dfs(idx + 1)
                sb.setLength(sb.length - 1)
            }

        }
        dfs(0)
        return ans
    }
}