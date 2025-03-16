# Majority Element 2

The reason that I had a hard time coming up with a solution at first is that the first question (Majority Element 1) did not have the validation phase. The second question (Majority Element 2) has the validation phase of O(n).

I was in this closed mindset that I could elegantly solve the problem with O(n) in the first phase, without the validation phase (second phase).

It turns out that it was much easier to just log two possible candidates and validate them in the second phase.

Lessons learned:
Do not be closed-minded. Be open to different solutions.
If an algorithm is to be generalized, it is better to have additional steps that aid the generalization, and those steps can be bound within the original time complexity.

```go
package main

import "fmt"

func majorityElementDesc(nums []int) []int {
var candidate1, candidate2, count1, count2 int

    fmt.Println("nums", nums)

    // First phase: Find up to two potential candidates that might appear more than ⌊n/3⌋ times.
    // The key insight is that there can be at most two such elements.

    for _, num := range nums {
     // If the current number matches the first candidate, increment its count.
     if count1 > 0 && num == candidate1 {
      count1++

      // Else if it matches the second candidate, increment its count.
     } else if count2 > 0 && num == candidate2 {
      count2++

      // If count1 is zero, we can assign the current number as the first candidate.
     } else if count1 == 0 {
      candidate1 = num
      count1 = 1

      // Else if count2 is zero, assign the current number as the second candidate.
     } else if count2 == 0 {
      candidate2 = num
      count2 = 1

      // If the current number matches neither candidate and both have non-zero counts,
      // decrement both counts (as part of "cancelling out" less frequent elements).
     } else {
      count1--
      count2--
     }
    }
    // Second phase: validate candidates
    count1, count2 = 0, 0
    for _, num := range nums {
     if num == candidate1 {
      count1++
     } else if num == candidate2 {
      count2++
     }
    }

    result := []int{}
    n := len(nums)
    if count1 > n/3 {
     result = append(result, candidate1)
    }
    if count2 > n/3 {
     result = append(result, candidate2)
    }
    return result

}

func main2() {
fmt.Println(majorityElement([]int{1}))
fmt.Println(majorityElement([]int{1, 2}))
fmt.Println(majorityElement([]int{1, 1, 2}))
fmt.Println(majorityElement([]int{1, 2, 3})) // invalid
fmt.Println(majorityElement([]int{1, 1, 1, 2, 2, 3}))
fmt.Println(majorityElement([]int{1, 1, 1, 1, 2, 3}))
fmt.Println(majorityElement([]int{1, 1, 1, 1, 1, 2, 2, 3}))
fmt.Println(majorityElement([]int{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3}))
}
```
