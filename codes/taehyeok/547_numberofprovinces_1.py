from typing import List

class DSU:
    def __init__(self, capacity):
        self.parent = [i for i in range(0, capacity)]

    def find(self, x):
        if x == self.parent[x]:
            return self.parent[x]
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x == root_y:
            return
        self.parent[root_x] = root_y

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        dsu = DSU(n)
        for row in range(len(isConnected)):
            for col in range(len(isConnected[0])):
                if isConnected[row][col] == 1:
                    dsu.union(row, col)
        province_root = set()
        for node in dsu.parent:
            parent = dsu.find(node)
            province_root.add(parent)
        return len(province_root)