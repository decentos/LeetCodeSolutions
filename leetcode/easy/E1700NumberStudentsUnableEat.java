package easy;

public class E1700NumberStudentsUnableEat {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] counter = new int[2];

        for (int student : students) {
            counter[student]++;
        }

        for (int sandwich : sandwiches) {
            if (counter[sandwich] == 0) {
                break;
            }
            counter[sandwich]--;
        }
        return counter[0] == 0 ? counter[1] : counter[0];
    }
}
