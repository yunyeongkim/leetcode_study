# Question
[997. Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/description/)

The goal is to find a town judge who is trusted by everyone else.

# Idea
- The town judge trusts nobody.
> The number of people who the town judge trusts is `0`.

- Everybody (except for the town judge) trusts the town judge.
> The number of people who trust the town judge is `number of people - 1`.

# Code
```swift
class Solution {
    func findJudge(_ n: Int, _ trust: [[Int]]) -> Int {
        var from = Array(repeating: 0, count: n+1)
        var to = Array(repeating: 0, count: n+1)

        for t in trust {
            from[t[0]] += 1
            to[t[1]] += 1
        }

        for index in 1..<n+1 {
            if from[index] == 0 && to[index] == n-1 {
                return index
            }
        }

        return -1
    }
}

```

# Complexity
- Time: O(N+M)
- Space: O(N)
