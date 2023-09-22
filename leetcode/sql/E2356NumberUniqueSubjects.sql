SELECT teacher_id, COUNT(DISTINCT subject_id) as cnt
FROM Teacher t
GROUP BY teacher_id;