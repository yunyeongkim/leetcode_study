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