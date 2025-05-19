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