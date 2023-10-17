SELECT
    d.name as Department,
    e1.name as Employee,
    e1.salary as Salary
FROM Employee e1
INNER JOIN Department d
ON e1.departmentId = d.id
WHERE (e1.departmentId, e1.salary) IN(
    SELECT e2.departmentId, MAX(e2.salary) as max_salary
    FROM Employee e2
    GROUP BY e2.departmentId
);