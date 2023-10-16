SELECT e.employee_id, t.team_size
FROM Employee e
INNER JOIN(
    SELECT e2.team_id, COUNT(*) as team_size
    FROM Employee e2
    GROUP BY e2.team_id
) t
ON e.team_id = t.team_id;

===============================

SELECT
    e.employee_id,
    COUNT(e.employee_id) OVER (PARTITION BY e.team_id) as team_size
FROM Employee e;