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