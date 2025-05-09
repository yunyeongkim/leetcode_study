func chatgpt_answer(nums []int, k int) int {
    // Map to store the frequency of cumulative sums
 prefixSumCount := make(map[int]int)

 // Initialize for the case where a subarray starting from index 0 has sum k
 prefixSumCount[0] = 1

 count := 0     // count of subarrays with sum k
 currentSum := 0 // running cumulative sum

 // Iterate through the array
 for _, num := range nums {
  // Add current element to the running sum
  currentSum += num

  // If (currentSum - k) exists in the map, it means we have subarrays ending
  // at the current position that sum to k
  if freq, exists := prefixSumCount[currentSum - k]; exists {
   count += freq
  }

  // Update the frequency of the current cumulative sum
  prefixSumCount[currentSum]++
 }

 return count
}


func my_refactor_but_wrong(nums []int, k int) int {
    // Map to store the frequency of cumulative sums
 prefixSumCount := make(map[int]int)

 // Initialize for the case where a subarray starting from index 0 has sum k
 prefixSumCount[0] = 1

 count := 0     // count of subarrays with sum k
 currentSum := 0 // running cumulative sum


    // Iterate through the array
 for _, num := range nums {
  // Add current element to the running sum
  currentSum += num

  // Update the frequency of the current cumulative sum
  prefixSumCount[currentSum]++
 }

    currentSum = 0

 // Iterate through the array
 for _, num := range nums {
  // Add current element to the running sum
  currentSum += num

  // If (currentSum - k) exists in the map, it means we have subarrays ending
  // at the current position that sum to k
  if freq, exists := prefixSumCount[currentSum - k]; exists {
   count += freq
  }

 }

 return count
}