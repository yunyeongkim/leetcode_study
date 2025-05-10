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