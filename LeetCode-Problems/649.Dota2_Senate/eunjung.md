 [649] [Dota2 Senate](https://leetcode.com/problems/dota2-senate/)
### _Explanation of the Question_

1. the Radiant and the Dire, two parties of in the Dota2 world
2. each senator can exercise one of the two rights.
	- Ban one senator's right 
	- Announce the victory
3. Example : senate = `R D D`
					R D D
					R ~~D~~ D
					~~R~~ ~~D~~ D

### _How to Solve_

**_Key point : Set priorities well according to the game rules_**

1. Create two arrays to separate the Radiant and Dire senators. Each array stores the index of their senators from the input `senate`.
	 - R = [0]
	 - D = [1, 2]
2. Senator 0 from Radiant gets to act first because its index has higher priority than senator 1 from Dire. Radiant bans `Dire`'s upcoming senator.
	- R = [0]
	- D = [2]
	 Then, `Radiant`'s senator is re-added
	 - R = [3]
	 - D = [2]
3. 2 of Dire remove 3 of Radiant. It doesn't need to change its priority because it is the only one from its party. So Dire is a winner in this game.
	 - R = []
	 - D = [2]
### _First Code_


```javascript
/**
 * @param {string} senate
 * @return {string}
 */
function predictPartyVictory(senate) {

    const radiant = [];
    const dire = [];
    let maxNum = senate.length - 1;

    for(let i = 0 ; i < senate.length ; i++){
        if(senate[i] === "R") radiant.push(i);
        else dire.push(i);
    }

    //validation check
    if(radiant.length === 0 && dire.length > 0) return "Dire";
    else if(radiant.length > 0 && dire.length === 0) return "Radiant";

    while(radiant.length > 0 && dire.length > 0){

        if(radiant[0] < dire[0]){//radiant's priority is higher than dire
            dire.shift();
            if(radiant.length > 0){
                if(dire.length > 0){
                    maxNum++;
                    radiant[0] = maxNum;
                }
                else return "Radiant";
            }
            radiant.sort();

        }else{//dire's priority is higher than radiant

            radiant.shift();
            if(dire.length > 0){
                if(radiant.length > 0){
                    maxNum++;
                    dire[0] = maxNum;
                }
                else return "Dire";
            }
            dire.sort();
        }
    }

    return false;
};
```

### _Second Code_

```javascript
function predictPartyVictory(senate) {

    const radiant = [];
    const dire = [];
    let maxNum = senate.length - 1;

    for(let i = 0 ; i < senate.length ; i++){
        if(senate[i] === "R") radiant.push(i);
        else dire.push(i);
    }

    //validation check
    if(radiant.length === 0 && dire.length > 0) return "Dire";
    else if(radiant.length > 0 && dire.length === 0) return "Radiant";

    while(radiant.length > 0 && dire.length > 0){
        const R = radiant.shift();
        const D = dire.shift();

        if(R < D){//radiant's priority is higher than dire
            radiant.push(maxNum++);
        }else{//dire's priority is higher than radiant
            dire.push(maxNum++);
        }
    }

    return radiant.length > 0 ? "Radiant" : "Dire";
};
```

### _Third Code_

**_Key point : Use Built-in function to brief the code_**


```javascript

function predictPartyVictory(senate) {
    const radiant = [];
    const dire = [];
    const n = senate.length;

    for (let i = 0; i < n; i++) {
        if (senate[i] === 'R') radiant.push(i);
        else dire.push(i);
    }

    while (radiant.length && dire.length) {
        const rIndex = radiant.shift();
        const dIndex = dire.shift();

        if (rIndex < dIndex) {

            radiant.push(rIndex + n);
        } else {

            dire.push(dIndex + n);
        }
    }

    return radiant.length ? "Radiant" : "Dire";
}
```