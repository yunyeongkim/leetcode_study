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