for i in depth..nums.len() {
            nums.swap(depth, i);               // try putting nums[i] in position `depth`
            permute_internal(nums, res, depth+1);   // recursively permute the rest
            nums.swap(depth, i);               // undo the change (backtrack)
        }