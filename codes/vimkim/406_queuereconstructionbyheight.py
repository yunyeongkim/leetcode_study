class Solution:

    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda p: (-p[0], p[1]))
        res = []
        for h, k in people:
            res.insert(k, (h, k))
        return res