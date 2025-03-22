> [!question]+
> Given a string `s`, find the length of the **longest** **substring** without duplicate characters.
> >[!example]+
> >**Input:** s = "abcabcbb"
> >**Output:** 3
> >**Explanation:** The answer is "abc", with the length of 3.
> 
> >[!example]+
> >**Input:** s = "pwwkew"
> >**Output:** 3
> >**Explanation:** The answer is "wke", with the length of 3.
> >Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
> 

### Definition
- **longest** **substring** characters without duplicate
	- "abccccddd" -> abc

### First Code
```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        count = 0
        max_count = 0
        chars = list(s)
        char_map ={}
        for i in range(len(chars)):
            if chars[i] not in char_map.keys():
                char_map[chars[i]] = 1
                count += 1
            else:
                char_map ={}
                char_map[chars[i]]= 1
                count = 1
            
            max_count = max(count, max_count)
        return max_count
# Wrong. 
# Not considerate restart. 
## a b c c a b c d 
```

### Second code 
```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        max_len = 0
        char_index = {}

        for right in range(len(s)):
            # when duplicated char exist, change left pointer
            if s[right] in char_index and char_index[s[right]] >= left:
                left = char_index[s[right]] + 1

            # renew the current pointer
            char_index[s[right]] = right

            # update window to max
            max_len = max(max_len, right - left + 1)
```

### Code Explain 
```yaml
a  b  c  c  a  b  c  d
↑
right / left
#char_index[s[right]] = right
#char_index[a] = 0
#max_lent = max(0, (0 - 0 + 1 )) -> 1
#                  start to end ,  plus 1 since loop starts from 0 

char_index = {
				a:0
}
```

```yaml
a     b  c  c  a  b  c  d
↑     ↑
left  right

#char_index[s[right]] = right
#char_index[b] = 1

#max_len = max(max_len, right - left + 1)
#max_lent = max( 1, (0 - 1 + 1 )) -> 2

char_index = {
				a:0
				b:1
}
```

```yaml
a   b   c  c  a  b  c  d
↑       ↑
left    right

#char_index[s[right]] = right
#char_index[c] = 2

#max_len = max(max_len, right - left + 1)
#max_lent = max( 2 , (0 - 2 + 1 )) -> 3
char_index = {
				a:0
				b:1
				c:2
}
```

```yaml
a   b   c  c  a  b  c  d
↑          ↑
left       right
### if s[right](s[3]:c) in char_index and char_index[s[right]] >= left:
# left = char_index[s[right]] + 1
# left = char_index[c] + 1 -> 2 + 1 -> 3

a   b   c  c  a  b  c  d
           ↑
       left,right
       
#char_index[s[right]] = right
#char_index[c] = 3

#max_len = max(max_len, right - left + 1)
#max_lent = max(3, (3 - 3 + 1 )) -> (3,1) -> 3
char_index = {
				a:0
				b:0
				c:2 -> c:3
}
```

```yaml
a   b   c  c    a  b  c  d
           ↑    ↑
          left  right
### if s[right](s[4]:a) in char_index and char_index[s[right](s[3]:c:3)] >= left:
### if s[4]:a exist in char_index (Okay)
### if char_index[s[right]] -> char_index[a](0) >= left (Not)

#char_index[s[right]] = right
#char_index[a] = 4

#max_len = max(max_len, right - left + 1)
#max_lent = max(3, (4 - 3 + 1 )) -> (3,2) -> 3

char_index = {
				a:0 -> a:4
				b:1
				c:3
}
```

```yaml
a   b   c  c  a  b  c  d
	       ↑     ↑
           left  right

#char_index[s[right]] = right
#char_index[b] = 5

#max_len = max(max_len, right - left + 1)
#max_lent = max(3, (5 - 3 + 1 )) -> (3,3) -> 3

char_index = {
				a:4
				b:1 -> b:5
				c:3
}
```

```yaml
a   b   c  c  a  b  c  d
	       ↑        ↑
           left     right
### if s[right] in char_index and char_index[s[right]] >= left:
# left = char_index[s[right]] + 1
# left = char_index[c] + 1 -> 3 + 1 -> 4

a   b   c  c  a  b  c  d
              ↑     ↑
            left    right
       
#char_index[s[right]] = right
#char_index[c] = 6

#max_len = max(max_len, right - left + 1)
#max_lent = max(3, (6 - 4 + 1 )) -> (3,3) -> 3
char_index = {
				a:4
				b:5
				c:3 -> c:6
}
```

```yaml
a   b   c  c  a  b  c  d
              ↑        ↑
            left      right
       
#char_index[s[right]] = right
#char_index[d] = 7

#max_len = max(max_len, right - left + 1)
#max_lent = max(3, (7 - 4 + 1 )) -> (3,4) -> 4
char_index = {
				a:4
				b:5
				c:6
				d:7
}
# {'a': 4, 'b': 5, 'c': 6, 'd': 7}
```