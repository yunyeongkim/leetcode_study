class Solution {
    public String predictPartyVictory(String senate) {
        int rcnt = 0, dcnt = 0, rscore = 0;
        var dq = new ArrayDeque<Character>();
        for (var c : senate.toCharArray()) {
            if (c == 'R')rcnt++;
            else dcnt++;
            dq.add(c);
        }

        while (rcnt > 0 && dcnt > 0) {
            var tmp = dq.pollFirst();
            if (tmp == 'R') {
                if (rscore < 0)rcnt--;
                else dq.addLast(tmp);
                rscore++;
            } else {
                if (rscore > 0)dcnt--;
                else dq.addLast(tmp);
                rscore--;
            }
        }
        return rcnt == 0 ? "Dire" : "Radiant";
    }
}