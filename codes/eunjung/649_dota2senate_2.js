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