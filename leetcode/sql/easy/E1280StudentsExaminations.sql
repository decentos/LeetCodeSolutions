SELECT s.student_id, s.student_name, sub.subject_name, IFNULL(e.attended_exams, 0) as attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN (
    SELECT student_id, subject_name, COUNT(*) as attended_exams
    FROM Examinations
    GROUP BY student_id, subject_name
) e
ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
ORDER BY s.student_id, sub.subject_name;
