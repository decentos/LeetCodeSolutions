SELECT r.project_id, r.employee_id
FROM(
    SELECT
        p.project_id,
        p.employee_id,
        RANK() OVER (PARTITION BY p.project_id ORDER BY e.experience_years DESC) rnk
    FROM Project p
    INNER JOIN Employee e
    ON p.employee_id = e.employee_id
) r
WHERE r.rnk = 1;