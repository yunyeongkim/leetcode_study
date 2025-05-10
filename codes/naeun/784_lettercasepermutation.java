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
<<<<<<< HEAD
}
=======
}
>>>>>>> d06107e (naeun - week12 784)
