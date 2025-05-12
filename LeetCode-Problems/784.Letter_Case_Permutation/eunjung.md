[Question 784. Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/description/)

### _Explanation of the Question_

1. transform every letter individually to be lowercase or uppercase to create another string.
	**Input:** s = "a1b2"
	**Output:** ["a1b2","a1B2","A1b2","A1B2"]

### _How to Solve_

                          a 1 b 2
				a - - -              A - - -  
				a 1 - -              A 1 - -
		a 1 b -  /  a 1 B -       A 1 b -  /  A 1 B -
		a 1 b 2  /  a 1 B 2       A 1 b 2  /  A 1 B 2

### _Code_
1. If index is same as value.length, we don't need to run backTrack().
```javascript
		if(index === value.length){
            allCombination.push(path);
            return;
        }
```

2. isNaN() returns boolean value..
	-  isNaN("a") // True
	-  isNaN("1") // False

```javascript
function letterCasePermutation(value){

    let allCombination = [];

    function backTrack(path, index){

        if(index === value.length){
            allCombination.push(path);
            return;
        }

        let singleString = value[index];

        if(isNaN(singleString)){// if it is a character
            backTrack(path + singleString.toLowerCase(), index + 1);
            backTrack(path + singleString.toUpperCase(), index + 1);
        }else{//if it is a number
            backTrack(path + singleString, index + 1);
        }
    }

    backTrack('', 0);

    return allCombination;
}
```