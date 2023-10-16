SELECT s.id, s.name
FROM Students s
WHERE s.department_id NOT IN(
    SELECT d.id
    FROM Departments d
);