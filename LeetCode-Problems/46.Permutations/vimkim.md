If the depth of the backtracking is equal to the length of the array, we have a complete permutation. We can then add a copy of the current permutation to the result list.

It is important to note that we need to swap the elements back after the recursive call to restore the original order of the array. This is crucial for generating all possible permutations.

### Goal: Generate all **permutations** of `nums`

If `nums = [1, 2, 3]`, you want to get:

```
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]
```

---

```rust
impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut res = vec![];
        let mut nums = nums;

        Self::permute_internal(&mut nums, &mut res, 0);

        res
    }

    fn permute_internal(nums: &mut Vec<i32>, res: &mut Vec<Vec<i32>>, depth: usize) {
        if depth == nums.len() {
            res.push(nums.clone());
            return;
        }

        for i in depth..nums.len() {
            // println!("{} {}", i, depth);
            nums.swap(i, depth);
            Self::permute_internal(nums, res, depth + 1);
            nums.swap(i, depth);
        }
    }
}
```

---

## Code Walkthrough

- `depth`: the index we’re trying to fill right now.
- `nums`: current state of the array (we mutate it in-place).
- `res`: result accumulator where we store each full permutation.

### Core Logic: Backtracking with Swaps

```rust
        if depth == nums.len() {
            res.push(nums.clone()); // found one permutation
            return;
        }
```

- If we've placed values in all positions (`start == nums.len()`), store the current `nums` as one valid permutation.

```rust
        for i in depth..nums.len() {
            nums.swap(depth, i);               // try putting nums[i] in position `depth`
            permute_internal(nums, res, depth+1);   // recursively permute the rest
            nums.swap(depth, i);               // undo the change (backtrack)
        }
```

### Example: `[1, 2, 3]`

Let’s see what the recursive calls look like:

```
start = 0:
  swap(0,0): [1,2,3]
    start = 1:
      swap(1,1): [1,2,3]
        start = 2:
          swap(2,2): [1,2,3] → result.push([1,2,3])
      swap(1,2): [1,3,2]
        start = 2:
          swap(2,2): [1,3,2] → result.push([1,3,2])
  swap(0,1): [2,1,3]
    ...
  swap(0,2): [3,2,1]
    ...
```

Each swap gives a new state to explore, and the reverse swap resets to try the next option. This is the classic **backtracking tree**.

---

### Time Complexity

- **Total permutations**: `n!` (factorial)
- **Each one** takes O(n) to clone → **O(n × n!)** total
