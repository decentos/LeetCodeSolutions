SELECT
    e1.reports_to as employee_id,
    e2.name as name,
    COUNT(*) as reports_count,
    ROUND(AVG(e1.age)) as average_age
FROM Employees e1
INNER JOIN Employees e2
ON e1.reports_to = e2.employee_id
GROUP BY e1.reports_to
ORDER BY e1.reports_to;
