func searchRange(nums []int, target int) []int {

    found := false;
    for _, value := range nums {
        if value == target {
            found = true
            break
        }
    }

    if !found {
        return []int{-1, -1}
    }

    return []int{0, 0}

}