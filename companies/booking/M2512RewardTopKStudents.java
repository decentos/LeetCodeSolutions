package booking;

import java.util.*;

public class M2512RewardTopKStudents {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < report.length; i++) {
            int points = calculate(positive, negative, report[i]);
            Student student = new Student(student_id[i], points);
            students.add(student);
        }
        Collections.sort(students);
        return students.stream().limit(k).map(s -> s.studentId).toList();
    }

// ===============================================================================

    public List<Integer> topStudents2(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        int n = report.length;
        Queue<Student> top = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int points = calculate(positive, negative, report[i]);
            updateTopRating(k, top, student_id[i], points);
        }

        LinkedList<Integer> ans = new LinkedList<>();
        while (!top.isEmpty()) {
            ans.addFirst(top.poll().studentId);
        }
        return ans;
    }

    private int calculate(Set<String> positive, Set<String> negative, String report) {
        int points = 0;
        String[] studentReport = report.split("\\s");
        for (String word : studentReport) {
            if (positive.contains(word)) {
                points += 3;
            } else if (negative.contains(word)) {
                points -= 1;
            }
        }
        return points;
    }

    private void updateTopRating(int size, Queue<Student> top, int studentId, int points) {
        if (top.size() < size) {
            top.offer(new Student(studentId, points));
        } else if (isHigher(top.peek(), studentId, points)) {
            top.poll();
            top.offer(new Student(studentId, points));
        }
    }

    private boolean isHigher(Student curr, int studentId, int points) {
        if (curr.points > points) return false;
        if (curr.points < points) return true;
        return curr.studentId > studentId;
    }

    private static class Student implements Comparable<Student> {
        int studentId;
        int points;

        public Student(int studentId, int points) {
            this.studentId = studentId;
            this.points = points;
        }

        @Override
        public int compareTo(Student o) {
            return points == o.points ? o.studentId - studentId : points - o.points;
        }
    }
}
