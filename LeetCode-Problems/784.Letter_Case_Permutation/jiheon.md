[problem](https://leetcode.com/problems/letter-case-permutation/description/)

## Solution
- For each character in  the String,  we have two choices:
	- use  lowercase version.
	- use uppercase (only if it is an english alphabet).
- When the index reaches the end of the String, add current String to answer array.

```java
class Solution {
   
     public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        List<String> ans = new ArrayList<>(s.length());
        dfs(s, 0, sb, ans);
        return ans;
    }

    private void dfs(String s, int idx, StringBuilder sb, List<String> answer) {
        if (idx == s.length()) {
            answer.add(sb.toString());
            return;
        }

        char c = s.charAt(idx);
        
        if (65 <= c && c <= 122) {
            sb.append(Character.toUpperCase(c));
            dfs(s, idx + 1, sb, answer);
            sb.setLength(sb.length() - 1);
            
            sb.append(Character.toLowerCase(c));
            dfs(s, idx + 1, sb, answer);
            sb.setLength(sb.length() - 1);
        }else{
            sb.append(c);
            dfs(s, idx + 1, sb, answer);
            sb.setLength(sb.length() - 1);
        }

    }

}
```


```kotlin
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
```