SELECT e.employee_id, e.department_id
FROM Employee e
WHERE e.primary_flag = 'Y' OR e.employee_id IN (
    SELECT employee_id
    FROM Employee
    GROUP BY employee_id
    HAVING COUNT(*) = 1
);