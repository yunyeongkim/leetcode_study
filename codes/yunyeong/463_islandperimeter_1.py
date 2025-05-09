def islandPerimeterSecond(self, grid):
        max_perimeter = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                # base case is 4
                if grid[i][j] == 1:
                    max_perimeter += 4
                    # if square exist above , remove 2
               ㅁ    if i > 0 and grid[i-1][j] == 1:
                        max_perimeter -= 2

                    # if square exist before remove -2
                    if j > 0 and grid[i][j-1] == 1:
                        max_perimeter -= 2
                
        return max_perimeter
        
#O(M∗N) 99.86% / O(1)