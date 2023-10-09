SELECT
    e.event_day as day,
    e.emp_id,
    SUM(out_time - in_time) as total_time
FROM Employees e
GROUP BY e.emp_id, e.event_day;