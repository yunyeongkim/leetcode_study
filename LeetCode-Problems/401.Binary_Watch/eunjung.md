[Question 401. Binary Watch](https://leetcode.com/problems/binary-watch/description/)
### _Explanation of the Question_

1.  Each LED represents a zero or one, with the least significant bit on the right.
		this means, binary numbers
2. H 8 4 2 1
		1:  0 0 0 1
		2:  0 0 1 0
		4:  0 1 0 0
		8:  1 0 0 0
		combinations are possible like 1 + 2 / 1 + 4 ... within 0~11
3. M 32 16 8 4 2 1
		1:  0 0 0 1
		2:  0 0 1 0
		4:  0 1 0 0
		8:  1 0 0 0
		16: 1 0 0 0 0
		32: 1 0 0 0 0 0
		combinations are possible like 1 + 2 / 1 + 4 ... within 0~59

### _How to Solve_

**_Key point : Find all combinations where turnedOn = number_**
1. Iterate through all possible time combinations(Hour range 0-11, Minute range 0-59), convert the hour and minute into binary
2. If the number of binary numbers. is same as turnedOn number, push the time in array

### _First Code_

Fail Reason: Once a Quotient is divided, Remainder variable should be assigned with new Quotient value.
```javascript
function binaryWatch(turnedOn){

    let timeCollect = [];

    for(let i = 0 ; i < 12 ; i++){// hour
        for(let j = 0 ; j < 60 ; j++){// minute

            let timeToBinary = [];

            if(i > 0){//Only when i is greater than 0

                let iQuotient = i;
                let iRemainder = i;

                while(iQuotient !== 1){
                    iQuotient = Math.floor(iQuotient / 2);
                    iRemainder = iRemainder % 2;   
                    if(iRemainder === 1) timeToBinary.push(iRemainder);
                }

                //if iQuotient is equal to 1 after division or for the first time
                if(iQuotient === 1) timeToBinary.push(iQuotient);
            }

            if(j > 0){//Only when j is greater than 0

                let jQuotient = j;
                let jRemainder = j;

                while(jQuotient !== 1){
                    jQuotient = Math.floor(jQuotient / 2);
                    jRemainder = jRemainder % 2;   
                    if(jRemainder === 1) timeToBinary.push(jRemainder);
                }

                //if jQuotient is equal to 1 after division or for the first time
                if(jQuotient === 1) timeToBinary.push(jQuotient);
            }

            if(timeToBinary.length === turnedOn){
                if(j < 10){//if the time is like 5:3, it should be converted to 5:03
                    timeCollect.push(i + ":" + "0" + j);
                }else{
                    timeCollect.push(i + ":" + j);
                }
            }
        }
    }

    return timeCollect;
}

let turnedOn = 9;
binaryWatch(turnedOn);
```

### _Second Code_

```javascript
function binaryWatch(turnedOn){

    let timeCollect = [];

    for(let i = 0 ; i < 12 ; i++){// hour
        for(let j = 0 ; j < 60 ; j++){// minute

            let timeToBinary = [];

            if(i > 0){//Only when i is greater than 0

                let iQuotient = i;
                let iRemainder = i;

                while(iQuotient !== 1){
                    iQuotient = Math.floor(iQuotient / 2);
                    iRemainder = iRemainder % 2;   
                    if(iRemainder === 1) timeToBinary.push(iRemainder);
                    iRemainder = iQuotient;
                }

                //if iQuotient is equal to 1 after division or for the first time
                if(iQuotient === 1) timeToBinary.push(iQuotient);
            }

            if(j > 0){//Only when j is greater than 0

                let jQuotient = j;
                let jRemainder = j;

                while(jQuotient !== 1){
                    jQuotient = Math.floor(jQuotient / 2);
                    jRemainder = jRemainder % 2;   
                    if(jRemainder === 1) timeToBinary.push(jRemainder);
                    jRemainder = jQuotient;
                }

                //if jQuotient is equal to 1 after division or for the first time
                if(jQuotient === 1) timeToBinary.push(jQuotient);
            }

            if(timeToBinary.length === turnedOn){
                if(j < 10){//if the time is like 5:3, it should be converted to 5:03
                    timeCollect.push(i + ":" + "0" + j);
                }else{
                    timeCollect.push(i + ":" + j);
                }
            }
        }
    }

    return timeCollect;
}

let turnedOn = 9;
binaryWatch(turnedOn);
```

### _Third Code_

**_Key point : Use Built-in function to brief the code_**

1. toString(2): convert to binary number
2. split(1).length - 1 : the number of binary digits. 
	ex) 1001 -> "","00",""
3. padStart(2, '0'): This fills the beginning of a string when its length is insufficient.
	ex) 5 -> 05

```javascript
function binaryWatch(turnedOn){

    let timeCollect = [];

    for(let i = 0 ; i < 12 ; i++){
        for(let j = 0 ; j < 60 ; j++){
            const timeToBinary = (i.toString(2) + j.toString(2)).split("1").length - 1;
            if(timeToBinary === turnedOn){
                timeCollect.push(i.toString() + ":" + j.toString().padStart(2,"0"));
            }
        }
    }

    return timeCollect;
}

let turnedOn = 2;
binaryWatch(turnedOn);
```