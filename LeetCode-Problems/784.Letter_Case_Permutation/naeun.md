Q: https://leetcode.com/problems/letter-case-permutation/description/
## Complexity
- 
![complexity](../../lib/images/naeun/784-complexity.png)
## Logic
- recursively check
    - check out of index
    - if not alphabet do with next index
    - if it is alphabet character
        - do change to uppercase and add result
        - do change to lowercase and add result
        => with this logic, if the result is List type, it would have duplicated elements. If make result with List type, you have to check whether lower case or upper case before changing. This needs additional if-else condition. Therefore, for the simple logic, I set the result as Set type. Anyway, it has to be checked whether lower case or not, so that transition logic does not be affected that much.

### mistakes during making logic
- duplicated elements were added.
- have to do recursion with next index even if it is numeric character.
- need to keep in mind of java transition function of character and string.

```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        // result
        Set<String> result = new HashSet<>();
        // recursion
        char[] sArray = s.toCharArray();
        result.add(s);
        doPermute(result, sArray, 0);

        return new ArrayList<>(result);
    }

    // if number continue
    // else to upper and lower
    private void doPermute(Set<String> result, char[] s, int index){
        // check out of idx
        if(index >= s.length){
            return;
        }

        if(Character.isDigit(s[index])){
            doPermute(result, s, index+1);
            return;
        }
        
        // lower -> upper
        s[index] =  Character.toUpperCase(s[index]); 
        result.add(new String(s));
        doPermute(result, s, index+1);
        // upper -> lower
        s[index] =  Character.toLowerCase(s[index]); 
        result.add(new String(s));
        doPermute(result, s, index+1);
        
    }
}

```
