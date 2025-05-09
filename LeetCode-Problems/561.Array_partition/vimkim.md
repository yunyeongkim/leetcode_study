Easy problem.

In order to save one, I must sacrifice someone.

And that sacrificed one must be just a little bit larger than the saved one, in order to maximized the saved values.

So I decided to sort the array and then just sum the first half of the array.

```go
func arrayPairSum(nums []int) int {
    sort.Ints(nums)
    sum := 0

    for i := 0; i < len(nums); i += 2 {
        sum += nums[i]
    }
    return sum
}
```
