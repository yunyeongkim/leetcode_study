class Solution(object):
    def islandPerimeter(self, grid):
        max_perimeter = 0
        perimeter = 0
        before_count = 0
        for i in range(len(grid)):
            count = 0
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    count += 1
            if count != 0:
                perimeter = 2*count + 2
                if i == 0 :
                    max_perimeter = perimeter
                elif before_count < count:
                    max_perimeter = (max_perimeter - before_count) + (perimeter - before_count)
                else:
                    max_perimeter = (max_perimeter - count) + (perimeter - count)
                print(f"max = {max_perimeter}")
                before_count = count
        return max_perimeter

# Failed.