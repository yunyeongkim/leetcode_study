class Solution {
       public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1]-b[1];
        });
        List<int[]> answer = new ArrayList<>(people.length);

        for (var person : people){
            answer.add(person[1],person);
        }

        return answer.toArray(new int[0][]);
    }
}