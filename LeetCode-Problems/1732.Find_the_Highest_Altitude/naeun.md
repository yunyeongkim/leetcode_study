```java
class Solution {
    public int largestAltitude(int[] gain) {
        // result is the maximum & default is zero
        int result = 0; 
        // calculate prefix sum (=누적합)
        int sum = 0;

        // iterate & decide which is maximum
        for(int g: gain){
            sum += g;
            result = Math.max(result, sum);
        }
        // return result
        return result;
    }
}
```