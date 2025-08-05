class Solution {
    func findCircleNum(_ isConnected: [[Int]]) -> Int {
        let citiesCount = isConnected.count
        var roots = Array(0..<citiesCount)

        func union(_ first: Int, _ second: Int) {
            if isConnected[first][second] == 1 {
                let firstRoot = roots[first]
                let secondRoot = roots[second]

                if firstRoot != secondRoot {
                    roots[second] = firstRoot
                }
            }
        }

        for first in 0..<citiesCount {
            for second in (first + 1)..<citiesCount {
                union(first, second)
            }
        }

        let provincesCount = Set(roots).count
        return provincesCount
    }
}