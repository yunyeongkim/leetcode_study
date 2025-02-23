
[question](https://leetcode.com/problems/array-partition/description)


## Idea

just simulate with simple case, `nums =[1,3,2,4]`

>`1`  is  smallest  in arr, so it will always be added to answer.
> That's because no matter what other element you combined with 1,  1 will always smaller.
>
>It also means that the other element  combined with `1` can't  added to answer.
>So, to minimize the damage , other element should be smallest in arr except for 1.
> just repeat this !!.


## First Code/Solution 

1. sort the arr to find (smallest, 2nd smallest) elemetns.
2.  if `idx % 2 == 0`, add element to answer, otherwise, just ignore it.

| smallest | 0th  | 1th   | 2th  | 3th   |
| -------- | ---- | ----- | ---- | ----- |
| num      | 1    | 2     | 3    | 4     |
| group    | 0    | 0     | 1    | 1     |
| min_val  | true | false | true | false |


```rust
impl Solution {
    pub fn array_pair_sum(mut nums: Vec<i32>) -> i32 {
        nums.sort_unstable();
        nums.iter().step_by(2).sum()
    }
}
```

