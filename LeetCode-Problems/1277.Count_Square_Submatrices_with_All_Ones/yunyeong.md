> [!question]+ Count Square Submatrices with All Ones
>Given a `m * n` matrix of ones and zeros, return how many **square** submatrices have all ones.
>
>> [!example]
>>**Example 1:**
>>**Input:** matrix =
>>[
>>[0,1,1,1],
>>[1,1,1,1],
>>[0,1,1,1]
>> **Explanation:** 
>> There are **10** squares of side 1.
>> There are **4** squares of side 2.
>> There is  **1** square of side 3.
>> Total number of squares = 10 + 4 + 1 = **15**.

### Definition:
- The maximum possible square size is **`min(len(matrix), len(matrix[0]))`**.
- Using a **DP approach**, we start from `(0,0)` and iterate over the entire matrix.
- `dp[i][j]` represents the **largest square ending at `(i, j)`**.
- The final result is the sum of all `dp[i][j]` values.

> [!Error]+ Shallow copy was even more faster than modifies directly or deep copy.
> I did 3 ways for more fast excution, and find out that **shallow copy** was more faster then any other way. 
> 
> *Here is Why*
> 
>  **1️⃣ `dp = matrix` Creates a Local Variable Reference**
>- When you use `dp = matrix`, **Python optimizes variable access**.
>- `dp[i][j]` is **a local variable reference**, which is **faster to access** than modifying `matrix[i][j]` directly in the loop.
>- **Why?**
>    - Local variables in Python **are optimized using C-level pointers**, making access faster.
>    - Accessing `matrix[i][j]` **requires Python to check multiple levels of reference resolution**, whereas `dp` is **a faster local alias**.
>**
>	**📌 Example of What Happens Internally:**
>```
># Slower (direct matrix modification)
>matrix[i][j] = min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1
>
 ># Faster (using a local reference)
>dp = matrix  # Local variable alias
>dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
>```


### First Solution
```python
class Solution:
    def countSquares(self, matrix: list[list[int]]) -> int:
        dp = matrix
        for i in range(len(matrix)):
                for j in range(len(matrix[i])):
                    if matrix[i][j] > 0 and i > 0 and j > 0:
                         # Fisrt line should be set as default.
                         dp[i][j] =  min(dp[i-1][j] , dp[i][j-1],dp[i-1][j-1]) + 1
        return sum(sum(row) for row in dp)
        
#Time Complexity: O(m × n), iterates over each cell once.
#Space Complexity: O(1) (In-place DP, no extra space).
```

### First code explain.
1. **Initialize DP Table**
    - Copy the `matrix` to `dp` using **Shallow copy** (`dp = matrix`).
    - The first row and first column remain unchanged (`dp[i][j] = matrix[i][j]`).
2. **Iterate Over the Matrix**
    - If `matrix[i][j] == 1` (a square can be formed):
        `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`
    - This ensures that `dp[i][j]` keeps track of the **maximum square size ending at `(i, j)`**.
3. **Calculate the Final Result**
    - Sum all values in `dp` to get the **total number of squares**.
![[count-square-submatrices-with-all-ones.excalidraw]]


