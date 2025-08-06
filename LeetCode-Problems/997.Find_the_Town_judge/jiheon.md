[problem](https://leetcode.com/problems/find-the-town-judge/)

## Solution
Simply count the following two things for each person
- How many people they trust.
- How many people trust them.
And determine who  the judge is(or not exists).


```Java
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] t = new int[n][2];

        for (int[] tt : trust) {
            t[tt[0] - 1][0]++;
            t[tt[1] - 1][1]++;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (t[i][0] == 0 && t[i][1] == n - 1) {
                if (ans != -1) {
                    return -1;
                }
                ans = i + 1;
            }
        }
        return ans;
    }
}
```