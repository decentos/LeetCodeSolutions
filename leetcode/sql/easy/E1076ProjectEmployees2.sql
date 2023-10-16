WITH employees_count AS(
    SELECT p.project_id, COUNT(*) as employees_count
    FROM Project p
    GROUP BY p.project_id
)
SELECT e.project_id
FROM employees_count e
WHERE e.employees_count = (SELECT MAX(e2.employees_count) FROM employees_count e2);

===============================

SELECT p1.project_id
FROM Project p1
GROUP BY p1.project_id
HAVING COUNT(*) = (
    SELECT COUNT(*)
    FROM Project p2
    GROUP BY p2.project_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);