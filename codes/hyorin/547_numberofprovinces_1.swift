class Solution {
    func findCircleNum(_ isConnected: [[Int]]) -> Int {
        let citiesCount = isConnected.count
        var roots = Array(0..<citiesCount)

        func find(_ city: Int) -> Int {
            if roots[city] != city {
                roots[city] = find(roots[city])
            }
            return roots[city]
        }

        func union(_ first: Int, _ second: Int) {
            if isConnected[first][second] == 1 {
                let firstRoot = find(first)
                let secondRoot = find(second)

                if firstRoot != secondRoot {
                    roots[secondRoot] = firstRoot
                }
            }
        }

        for first in 0..<citiesCount {
            for second in (first + 1)..<citiesCount {
                union(first, second)
            }
        }

        let provincesCount = Set(roots.map { find($0)}).count
        return provincesCount
    }
}