class Solution {
       public int countStudents(int[] students, int[] sandwiches) {
        int[] prefer = new int[2];

        for (int student : students) {
            prefer[student]++;
        }

        for (int sandwich : sandwiches) {
            if (prefer[sandwich] <= 0) return prefer[1 - sandwich];
            prefer[sandwich]--;
        }
        return 0;
    }
}