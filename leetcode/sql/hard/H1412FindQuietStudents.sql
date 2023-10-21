WITH Score AS(
    SELECT
        e.student_id,
        RANK() OVER (PARTITION BY e.exam_id ORDER BY e.score) as min_score,
        RANK() OVER (PARTITION BY e.exam_id ORDER BY e.score DESC) as max_score
    FROM Exam e
)
SELECT DISTINCT s.student_id, s.student_name
FROM Student s
INNER JOIN Exam e
ON s.student_id = e.student_id
WHERE s.student_id NOT IN(
    SELECT sc.student_id
    FROM Score sc
    WHERE sc.min_score = 1 OR sc.max_score = 1
)
ORDER BY s.student_id;