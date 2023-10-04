  SELECT (
    SELECT DISTINCT e.salary
    FROM Employee e
    ORDER BY e.salary DESC
    LIMIT 1 OFFSET 1
  ) as SecondHighestSalary;
