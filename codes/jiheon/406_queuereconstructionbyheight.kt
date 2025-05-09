class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(compareBy({ -it[0] }, { it[1] }))
        val result = mutableListOf<IntArray>()
        for (person in people) {
            result.add(person[1], person)
        }
        return result.toTypedArray()
    }
}