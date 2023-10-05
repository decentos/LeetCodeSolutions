SELECT r.Department, r.Employee, r.Salary
FROM(
    SELECT
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        DENSE_RANK() OVER (PARTITION BY d.id ORDER BY e.salary DESC) as dep_rank
    FROM Employee e
    INNER JOIN Department d
    ON e.departmentId = d.id
) r
WHERE r.dep_rank <= 3;
