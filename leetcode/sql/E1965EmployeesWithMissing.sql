SELECT e.employee_id
FROM Employees e
WHERE e.employee_id NOT IN (
  SELECT s.employee_id
  FROM Salaries s
)
UNION
SELECT s.employee_id
FROM Salaries s
WHERE s.employee_id NOT IN (
  SELECT e.employee_id
  FROM Employees e
)
ORDER BY employee_id;