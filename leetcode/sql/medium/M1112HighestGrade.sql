SELECT e1.student_id, MIN(e1.course_id) as course_id, e1.grade
FROM Enrollments e1
INNER JOIN(
    SELECT e2.student_id, MAX(e2.grade) as grade
    FROM Enrollments e2
    GROUP BY e2.student_id
) e2
ON e1.student_id = e2.student_id AND e1.grade = e2.grade
GROUP BY e1.student_id
ORDER BY e1.student_id;

===============================

SELECT e1.student_id, MIN(e1.course_id) as course_id, e1.grade
FROM Enrollments e1
WHERE (e1.student_id, e1.grade) IN(
    SELECT e2.student_id, MAX(e2.grade) as grade
    FROM Enrollments e2
    GROUP BY e2.student_id
)
GROUP BY e1.student_id
ORDER BY e1.student_id;
