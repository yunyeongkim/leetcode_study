Q: https://leetcode.com/problems/letter-case-permutation/description/
## Complexity
- time complexity: O(n* 2^n) - n for converting array to string and 2^n for each step having 2 options.
- space complexity: O(n * 2^n) - n for stack and 2^n for each step having 2 options.

![complexity](/lib/images/naeun/784-complexity.png)
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
- hard to deal with original String.

### check for improvement
- needed help to calculate complexity both in time and space.

## Code
### My solution

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

### let gpt improve my code
```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] s, int index, List<String> result) {
        if (index == s.length) {
            result.add(new String(s));
            return;
        }

        if (Character.isLetter(s[index])) {
            // lowercase
            s[index] = Character.toLowerCase(s[index]);
            backtrack(s, index + 1, result);
            // uppercase
            s[index] = Character.toUpperCase(s[index]);
            backtrack(s, index + 1, result);
        } else {
            backtrack(s, index + 1, result);
        }
    }
}
```

### other's solution
- https://leetcode.com/problems/letter-case-permutation/solutions/1068812/java-backtracking-with-recursion-tree-diagram-1ms-beats-100/ 
```java
class Solution {
    
    void recurse(char[] str, int pos, List<String> result) {
        //If we have reached a leaf in the recursion tree, save the result.
        if (pos == str.length) {
            result.add(new String(str));
            return;
        }
        
        //If char is not a letter, no processing required.
        if (Character.isLetter(str[pos])) {
            //If uppercase char, we make it lower case, and recurse.
            if (Character.isUpperCase(str[pos])) {
                str[pos] = Character.toLowerCase(str[pos]);
                
                //Start a new branch in the recursion tree, exploring options that are possible only if we had changed the case.
                recurse(str, pos + 1, result);
                
                //Backtracking. We undo the change so that we can start a new branch in the recursion tree.
                str[pos] = Character.toUpperCase(str[pos]);
            }
            //If lowercase, then we make it upper case, and recurse.
            else {
                str[pos] = Character.toUpperCase(str[pos]);
                recurse(str, pos + 1, result);
                //Backtracking as explained above.
                str[pos] = Character.toLowerCase(str[pos]);
            }
        }
        //This branch explores options that are possible only if the previously performed change (if any) hadn't happened.
        recurse(str, pos + 1,  result);
    }
    
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        recurse(S.toCharArray(), 0, result);
        return result;
    }
}
```
